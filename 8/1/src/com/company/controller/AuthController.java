package com.company.controller;

import com.company.exception.AuthException;
import com.company.model.UserEnt;
import com.company.model.UserRepo;
import com.company.service.IO;
import com.company.service.MySQL;

import java.sql.SQLException;

public class AuthController {
    private AuthController(){}

    private static final AuthController instance = new AuthController();

    public static AuthController getInstance() {
        return instance;
    }

    private boolean isAuthenticated = false;

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void login() throws SQLException {
        try {
            String username = IO.getInstance().getString("Enter Username:");
            String password = IO.getInstance().getString("Enter Password:");

            UserEnt user = UserRepo.getInstance().findByUsername(username)
                    .orElseThrow(()->new AuthException("Error: username and password not matched!"));
            if (!user.getPassword().equals(password)){
                throw new AuthException("Error: username and password not matched!");
            }
            else {
                isAuthenticated = true;
                userInfo = user;
            }
            ValueController.getInstance().chooseActProcess();

        }catch (AuthException e){
            e.printStackTrace();
            enterToSystem();
        }
    }

    public void signup() throws SQLException {
        try {
            UserEnt user = new UserEnt();
            user.setName(IO.getInstance().getString("Enter Name:"))
                    .setUsername(IO.getInstance().getString("Enter Username:"))
                    .setPassword(IO.getInstance().getString("Enter Password:"));

            if (UserRepo.getInstance().findByUsername(user.getUsername()).orElse(null) == null){
                UserRepo.getInstance().save(user);
                isAuthenticated = true;
                userInfo = user;
            }
            else throw new AuthException("Error: username is already taken!");
            MySQL.getInstance().commit();
            ValueController.getInstance().chooseActProcess();

        }catch (AuthException e){
            e.printStackTrace();
            enterToSystem();
        }
    }
    public void enterToSystem() throws SQLException {
        String state = IO.getInstance().getString("\nFor Login enter 1 \nFor Signup enter anything else");
        if (state.equals("1")) login();
        else signup();
    }
    public void logout() throws SQLException {
        isAuthenticated = false;
        userInfo = null;
        enterToSystem();
    }
    private UserEnt userInfo;

    public UserEnt getUserInfo() {
        return userInfo;
    }
}

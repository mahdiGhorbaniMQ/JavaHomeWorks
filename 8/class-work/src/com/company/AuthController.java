package com.company;

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

            User user = UserDAO.getInstance().findByUsername(username)
                    .orElseThrow(()->new AuthException("Error: username and password not matched!"));
            if (!user.getPassword().equals(password)){
                throw new AuthException("Error: username and password not matched!");
            }
            else {
                isAuthenticated = true;
                userInfo = user;
            }
        }catch (AuthException e){
            e.printStackTrace();
            enterToSystem();
        }
    }

    public void signup() throws SQLException {
        try {
            User user = new User();
            user.setName(IO.getInstance().getString("Enter Name:"))
                    .setEmail(IO.getInstance().getString("Enter Email:"))
                    .setUsername(IO.getInstance().getString("Enter Username:"))
                    .setPassword(IO.getInstance().getString("Enter Password:"));

            if (UserDAO.getInstance().findByUsername(user.getUsername()).orElse(null) == null){
                UserDAO.getInstance().save(user);
                isAuthenticated = true;
                userInfo = user;
            }
            else throw new AuthException("Error: username is already taken!");

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
    private User userInfo;

    public User getUserInfo() {
        return userInfo;
    }
}

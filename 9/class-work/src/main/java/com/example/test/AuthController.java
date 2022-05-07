package com.example.test;


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

    public void login(String username, String password) throws SQLException, AuthException {
        User user = UserDAO.getInstance().findByUsername(username)
                .orElseThrow(()->new AuthException("Error: username and password not matched!"));
        if (!user.getPassword().equals(password))
            throw new AuthException("Error: username and password not matched!");

        isAuthenticated = true;
        userInfo = user;
    }

    public void register(User user) throws SQLException, AuthException {

        if(UserDAO.getInstance().findByUsername(user.getUsername()).orElse(null) != null)
            throw new AuthException("Error: Username is already taken!");
        if(UserDAO.getInstance().findByEmail(user.getEmail()).orElse(null) != null)
            throw new AuthException("Error: Email is already taken!");

        UserDAO.getInstance().save(user);
        isAuthenticated = true;
        userInfo = user;
    }

    public void signOut(){
        userInfo = new User();
        isAuthenticated = false;
    }
    public void deleteAccount() throws SQLException {
        UserDAO.getInstance().delete(userInfo);
        userInfo = new User();
        isAuthenticated = false;
    }
    private User userInfo = new User();

    public User getUserInfo() {
        return userInfo;
    }
}

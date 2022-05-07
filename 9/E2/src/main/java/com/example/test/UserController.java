package com.example.test;

import java.sql.SQLException;

public class UserController {
    private UserController(){}
    private static final UserController instance = new UserController();
    public static UserController getInstance() {
        return instance;
    }
    public void update(User user) throws SQLException {
        UserDAO.getInstance().save(user);
    }
}

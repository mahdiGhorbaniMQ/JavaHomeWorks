package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            AuthController.getInstance().enterToSystem();
            System.out.println("\n"+AuthController.getInstance().getUserInfo().toString());
//            UserDAO.getInstance().delete(AuthController.getInstance().getUserInfo());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQL.getInstance().close();
        }
    }
}

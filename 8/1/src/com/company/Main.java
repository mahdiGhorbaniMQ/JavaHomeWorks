package com.company;

import com.company.controller.AuthController;
import com.company.service.MySQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            AuthController.getInstance().enterToSystem();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MySQL.getInstance().close();
        }
    }
}

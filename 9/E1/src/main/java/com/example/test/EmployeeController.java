package com.example.test;

import java.sql.SQLException;

public class EmployeeController {
    private EmployeeController(){}
    private static final EmployeeController instance = new EmployeeController();
    public static EmployeeController getInstance() {
        return instance;
    }
    public void add(Employee employee) throws SQLException {
        EmployeeDAO.getInstance().save(employee);
    }
}

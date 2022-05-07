package com.example.test;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeeDAO {

    public void save(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = MySQL.getInstance()
                .prepareStatement("insert into L8.employee values (default, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getExperience());
        preparedStatement.setString(3, employee.getJobTitle());
        preparedStatement.setString(4, employee.getSalary());
        preparedStatement.setString(5, employee.getStaff());
        preparedStatement.executeUpdate();
    }


    private EmployeeDAO(){}

    private static final EmployeeDAO instance = new EmployeeDAO();

    public static EmployeeDAO getInstance() {
        return instance;
    }
}

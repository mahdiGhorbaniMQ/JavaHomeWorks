package com.example.e1;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
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

    public Collection<Employee> findAll() throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L8.employee");
        Collection<Employee> employees = new HashSet<>();
        if (result.next()) {
            Employee employee = new Employee();
            employee.setName(result.getString("name"));
            employee.setJobTitle(result.getString("job_title"));
            employee.setExperience(result.getString("experience"));
            employee.setSalary(result.getString("salary"));
            employee.setStaff(result.getString("staff"));

            employees.add(employee);
        }
        return employees;
    }
    private EmployeeDAO(){}

    private static final EmployeeDAO instance = new EmployeeDAO();

    public static EmployeeDAO getInstance() {
        return instance;
    }
}

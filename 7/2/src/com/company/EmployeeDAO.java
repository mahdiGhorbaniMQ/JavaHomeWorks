package com.company;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeeDAO {

    public Optional<Employee> findByEmployeeNumber(int employeeNumber) throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L6.employee where employee_number = " + employeeNumber );
        Employee employee = null;
        if (result.next()) {
            employee = new Employee();
            employee.setEmployee_number(result.getInt("employee_number"));
            employee.setName(result.getString("name"));
            employee.setNational_code(result.getString("national_code"));
            employee.setFather_name(result.getString("father_name"));
            employee.setEmployee_position(result.getString("employee_position"));
            employee.setSalary(result.getInt("salary"));
            employee.setExperience(result.getInt("experience"));
        }
        return Optional.ofNullable(employee);
    }
    public void save(Employee employee) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L6.employee where employee_number = " + employee.getEmployee_number());

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L6.employee\n" +
                            "SET name = ?, national_code= ?, father_name= ?, employee_position= ?, salary= ?, experience= ?\n" +
                            "WHERE employee_number = ?");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getNational_code());
            preparedStatement.setString(3, employee.getFather_name());
            preparedStatement.setString(4, employee.getEmployee_position());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.setInt(7, employee.getEmployee_number());

            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L6.employee values (default, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getNational_code());
            preparedStatement.setString(3, employee.getFather_name());
            preparedStatement.setString(4, employee.getEmployee_position());
            preparedStatement.setInt(5, employee.getSalary());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Employee employee) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L6.employee WHERE employee_number = " + employee.getEmployee_number())
                .executeUpdate();
    }


    private EmployeeDAO(){}

    private static final EmployeeDAO instance = new EmployeeDAO();

    public static EmployeeDAO getInstance() {
        return instance;
    }
}

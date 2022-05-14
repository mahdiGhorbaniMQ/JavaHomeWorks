package com.example.e1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeController {
    private EmployeeController(){}
    private static final EmployeeController instance = new EmployeeController();
    public static EmployeeController getInstance() {
        return instance;
    }
    public void add(Employee employee) throws SQLException {
        EmployeeDAO.getInstance().save(employee);
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/com/example/e1/log.txt");
            fileWriter.write(employee.toString()+"\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Employee> getAll() throws SQLException {
        return new ArrayList<>(EmployeeDAO.getInstance().findAll());
    }
}

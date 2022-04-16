package com.company;

import java.sql.SQLException;

public class Controller {
    private Controller(){}
    private static final Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    public Employee getEmployee(){
        return new Employee(
                IO.getInstance().getString("Enter Name:"),
                IO.getInstance().getString("Enter National_code:"),
                IO.getInstance().getString("Enter Father_name:"),
                IO.getInstance().getString("Enter Employee_position:"),
                IO.getInstance().getInteger("Enter Salary:"),
                IO.getInstance().getInteger("Enter Experience:")
        );
    }

    public String getState(){
        return IO.getInstance().getString("For add Employee enter 1,\n" +
                "for delete employee enter 2,\n" +
                "for update employee enter something else");
    }

    public void start() throws SQLException {
        try {
            switch (getState()){
                case "1":{
                    Employee employee = getEmployee();
                    if(EmployeeDAO.getInstance()
                            .findByEmployeeNumber(employee.getEmployee_number())
                            .orElse(null) == null) {
                        EmployeeDAO.getInstance().save(employee);
                    }
                    else throw new Exception("Error: Employee_Number is already taken!");
                    start();
                    break;
                }
                case "2":{
                    int employee_number = IO.getInstance().getInteger("Enter Employee_number:");
                    Employee employee = EmployeeDAO.getInstance().findByEmployeeNumber(employee_number)
                            .orElse(null);
                    if (employee != null){
                        EmployeeDAO.getInstance().delete(employee);
                    }
                    else throw new Exception("Error: Employee not found!");
                    start();
                    break;
                }
                default:{
                    int employee_number = IO.getInstance().getInteger("Enter Employee_number:");
                    Employee employee = EmployeeDAO.getInstance().findByEmployeeNumber(employee_number)
                            .orElse(null);
                    if (employee != null){
                        System.out.println("\n"+employee.toString());
                        EmployeeDAO.getInstance().save(getEmployee().setEmployee_number(employee_number));
                    }
                    else throw new Exception("Error: Employee not found!");
                    start();
                    break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            start();
        }finally {
            MySQL.getInstance().close();
        }

    }
}

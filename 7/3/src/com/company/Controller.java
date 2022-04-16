package com.company;

import java.sql.SQLException;

public class Controller {
    private Controller(){}
    private static final Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    public Student getStudent(){
        return new Student(
                IO.getInstance().getString("Enter Name:"),
                IO.getInstance().getInteger("Enter Entering_year:"),
                IO.getInstance().getFloat("Enter Average:")
        );
    }

    public String getState(){
        return IO.getInstance().getString("For add Student enter 1,\n" +
                "for delete Student enter 2,\n" +
                "for update Student enter something else");
    }

    public void start() throws SQLException {
        try {
            switch (getState()){
                case "1":{
                    Student student = getStudent();
                    StudentDAO.getInstance().save(student);
                    start();
                    break;
                }
                case "2":{
                    int student_code = IO.getInstance().getInteger("Enter Student_code:");
                    Student student = StudentDAO.getInstance().findByStudentCode(student_code)
                            .orElse(null);
                    if (student != null){
                        StudentDAO.getInstance().delete(student);
                    }
                    else throw new Exception("Error: Student not found!");
                    start();
                    break;
                }
                default:{
                    int student_code = IO.getInstance().getInteger("Enter Student_code:");
                    Student student = StudentDAO.getInstance().findByStudentCode(student_code)
                            .orElse(null);
                    if (student != null){
                        System.out.println("\n"+ student.toString());
                        StudentDAO.getInstance().save(getStudent().setStudent_code(student_code));
                    }
                    else throw new Exception("Error: Student not found!");
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

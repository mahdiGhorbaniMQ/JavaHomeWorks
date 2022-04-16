package com.company;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class StudentDAO {

    public Optional<Student> findByStudentCode(int student_code) throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L6.student where student_code = " + student_code );
        Student student = null;
        if (result.next()) {
            student = new Student();
            student.setStudent_code(result.getInt("student_code"));
            student.setName(result.getString("name"));
            student.setEntering_year(result.getInt("enteringـyear"));
            student.setAverage(result.getInt("average"));
        }
        return Optional.ofNullable(student);
    }
    public void save(Student student) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L6.student where student_code = " + student.getStudent_code());

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L6.student\n" +
                            "SET name = ?, enteringـyear= ?, average= ?\n" +
                            "WHERE student_code = ?");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getEntering_year());
            preparedStatement.setFloat(3, student.getAverage());
            preparedStatement.setInt(4, student.getStudent_code());

            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L6.student values (default, ?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getEntering_year());
            preparedStatement.setFloat(3, student.getAverage());
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Student student) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L6.student WHERE student_code = " + student.getStudent_code())
                .executeUpdate();
    }


    private StudentDAO(){}

    private static final StudentDAO instance = new StudentDAO();

    public static StudentDAO getInstance() {
        return instance;
    }
}

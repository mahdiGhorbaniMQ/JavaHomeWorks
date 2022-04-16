package com.company;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {

    public Optional<User> findByUserNumber(int userNumber) throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L6.users where userNumber = " + userNumber);
        User user = null;
        if (result.next()) {
            user = new User();
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setEducation(result.getString("education"));
            user.setUserNumber(result.getInt("userNumber"));
            user.setAge(result.getInt("age"));
            user.setPassword(result.getString("password"));
        }
        return Optional.ofNullable(user);
    }
    public void save(User user) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L6.users where userNumber = " + user.getUserNumber());

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L6.users\n" +
                            "SET name = ?, email= ?, education= ?, age=?\n" +
                            "WHERE userNumber = ?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getEducation());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, user.getUserNumber());
            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L6.users values (default, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getEducation());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, user.getUserNumber());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }
    public void delete(User user) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L6.users WHERE username = " + user.getUserNumber())
                .executeUpdate();
    }


    private UserDAO(){}

    private static final UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }
}

package com.company;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO {

    public Optional<User> findByUsername(String username) throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L6.users where username = '" + username + "'");
        User user = null;
        if (result.next()) {
            user = new User();
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
        }
        return Optional.ofNullable(user);
    }
    public void save(User user) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L6.users where username = '" + user.getUsername() + "'");

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L6.users\n" +
                            "SET name = ?, email= ?\n" +
                            "WHERE username = ?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L6.users values (default, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }
    public void delete(User user) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L6.users WHERE username = '" + user.getUsername() + "'")
                .executeUpdate();
    }


    private UserDAO(){}

    private static final UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }
}

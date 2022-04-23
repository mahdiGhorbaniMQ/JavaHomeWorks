package com.company.model;

import com.company.service.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepo {
    public Optional<UserEnt> findByUsername(String username) throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L7.user where username = '" + username + "'");
        UserEnt user = null;
        if (result.next()) {
            user = new UserEnt();
            user.setName(result.getString("name"));
            user.setDept(result.getInt("dept"));
            user.setNet_value(result.getInt("net_value"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
        }
        return Optional.ofNullable(user);
    }
    public void save(UserEnt user) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L7.user where username = '" + user.getUsername() + "'");

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L7.user\n" +
                            "SET name = ?, dept= ?, net_value=?\n" +
                            "WHERE username = ?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getDept());
            preparedStatement.setInt(3, user.getNet_value());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L7.user values (default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getDept());
            preparedStatement.setInt(3, user.getNet_value());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }
    public void delete(UserEnt user) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L7.user WHERE username = '" + user.getUsername() + "'")
                .executeUpdate();
    }


    private UserRepo(){}

    private static final UserRepo instance = new UserRepo();

    public static UserRepo getInstance() {
        return instance;
    }
}

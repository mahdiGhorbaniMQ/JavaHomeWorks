package com.company;


import java.sql.*;

public class MySQL {
    private Connection connection;
    private Statement statement;

    private MySQL(){}
    private static final MySQL instance = new MySQL();

    public static MySQL getInstance() throws SQLException {
        if (instance.connection == null){
            instance.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/L6?useSSL=true",
                    "root",
                    "mypassword"
            );
            instance.statement = instance.connection.createStatement();
        }
        return instance;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}

package com.example.test;

public class User {
    private String name;
    private String email;
    private String username;
    private String password;

    public User(){}

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User(String name, String email, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "name: " + name + '\n' +
                "email: " + email + '\n' +
                "username: " + username + '\n' +
                "password: " + password + '\n';
    }
}

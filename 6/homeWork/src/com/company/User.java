package com.company;

public class User {
    private String name;
    public String username;
    private String password;
    private int age;

    public User(){}
    public User(String name, String username, String password, int age){
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        String output = "";
        output += name!=null ?("name: " + name + '\n') :"";
        output += username!=null ?("username: " + username + '\n') :"";
        output += password!=null ?("password: " + password + '\n') :"";
        output += age>0 ?("age: " + age):"";
        return output;
    }
}

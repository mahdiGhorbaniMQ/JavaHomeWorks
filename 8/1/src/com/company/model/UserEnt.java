package com.company.model;

public class UserEnt {
    private String name;
    private String username;
    private String password;
    private int dept;
    private int net_value;



    public UserEnt(){}
    public UserEnt(String name, String username, String password){}


    public String getName() {
        return name;
    }

    public UserEnt setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEnt setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEnt setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getDept() {
        return dept;
    }

    public UserEnt setDept(int dept) {
        this.dept = dept;
        return this;
    }

    public int getNet_value() {
        return net_value;
    }

    public UserEnt setNet_value(int net_value) {
        this.net_value = net_value;
        return this;
    }

    @Override
    public String toString() {
        return
                "name: " + name + "\n" +
                "dept: " + dept + "\n" +
                "net value: " + net_value + "\n" +
                "username: " + username + "\n";
    }
}

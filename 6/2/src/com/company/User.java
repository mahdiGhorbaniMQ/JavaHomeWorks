package com.company;

public class User {
    private String name;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String education;
    private int age;

    public User(){}

    public User(String name, String username, String password, String address, String phone, String education, int age){
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.education = education;
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

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public User setEducation(String education) {
        this.education = education;
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
        return
                "your full name: " + name + '\n' +
                        "your age: " + age +
                        "your username: '" + username + '\n' +
                        "your password: " + password + '\n' +
                        "your education: " + education + '\n' +
                        "your address: " + address + '\n' +
                        "your phone number: " + phone + '\n';
    }
}

package com.company;

public class User {
    private String name;
    private String email;
    private String education;
    private int userNumber;
    private int age;
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


    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public User setEducation(String education) {
        this.education = education;
        return this;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public User setUserNumber(int userNumber) {
        this.userNumber = userNumber;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User(String name, String email, String education, int userNumber, int age, String password){
        this.name = name;
        this.email = email;
        this.education = education;
        this.userNumber = userNumber;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "name: " + name + '\n' +
                "email: " + email + '\n' +
                "education: " + education + '\n' +
                "userNumber: " + userNumber + '\n' +
                "age: " + age + '\n' +
                "password: " + password + '\n';
    }
}

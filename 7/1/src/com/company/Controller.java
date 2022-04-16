package com.company;

public class Controller {
    private Controller(){}
    private static final Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    public String chooseState(){
        return IO.getInstance().getString("For create user enter 1 and For update user enter something else:");
    }

    public User getUser(){
        return new User()
                .setName(IO.getInstance().getString("Enter Name:"))
                .setEmail(IO.getInstance().getString("Enter Email:"))
                .setEducation(IO.getInstance().getString("Enter Education:"))
                .setAge(IO.getInstance().getInteger("Enter Age:"))
                .setUserNumber(IO.getInstance().getInteger("Enter User Number:"))
                .setPassword(IO.getInstance().getString("Enter Password:"));
    }
}

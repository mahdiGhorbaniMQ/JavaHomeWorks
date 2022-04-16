package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            if(Controller.getInstance().chooseState().equals("1")){
                User user = Controller.getInstance().getUser();

                if (UserDAO.getInstance().findByUserNumber(user.getUserNumber()).orElse(null) == null){
                    UserDAO.getInstance().save(user);
                }
                else {
                    System.out.println("Error: UserNumber is already taken!");
                }
            }
            else {
                int userNumber = IO.getInstance().getInteger("Enter UserNumber:");
                User user = UserDAO.getInstance().findByUserNumber(userNumber).orElseThrow(()->new Exception(""));
                System.out.println(user.toString());
                user.setName(IO.getInstance().getString("Enter Name:"))
                        .setEducation(IO.getInstance().getString("Enter Education:"))
                        .setEmail(IO.getInstance().getString("Enter Email"))
                        .setAge(IO.getInstance().getInteger("Enter Age:"));
                UserDAO.getInstance().save(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MySQL.getInstance().close();
        }
    }
}

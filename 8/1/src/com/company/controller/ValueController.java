package com.company.controller;

import com.company.model.UserService;
import com.company.service.IO;

import java.sql.SQLException;

public class ValueController {
    private ValueController(){}
    private final static ValueController instance = new ValueController();

    public static ValueController getInstance() {
        return instance;
    }

    void showList(){
        System.out.println("1) 2 Gig - 1000$");
        System.out.println("2) 4 Gig - 2000$");
        System.out.println("3) 10 Gig - 5000$");
        System.out.println("4) 25 Gig - 10000$");
    }

    void boyItem(String number) throws SQLException {
        switch (number){
            case "1":{
                System.out.println("Boy 2 Gig - 1000$");
                if (IO.getInstance().getString("is that ok? type yes or no").equals("yes"))
                    UserService.getInstance().boy(AuthController.getInstance().getUserInfo(), 1000,2);
                break;
            }
            case "2":{
                System.out.println("Boy 4 Gig - 2000$");
                if (IO.getInstance().getString("is that ok? type yes or no").equals("yes"))
                    UserService.getInstance().boy(AuthController.getInstance().getUserInfo(), 2000,4);
                break;
            }
            case "3":{
                System.out.println("Boy 10 Gig - 5000$");
                if (IO.getInstance().getString("is that ok? type yes or no").equals("yes"))
                    UserService.getInstance().boy(AuthController.getInstance().getUserInfo(), 5000,10);
                break;
            }
            case "4":{
                System.out.println("Boy 25 Gig - 10000$");
                if (IO.getInstance().getString("is that ok? type yes or no").equals("yes"))
                    UserService.getInstance().boy(AuthController.getInstance().getUserInfo(), 10000,25);
                break;
            }
            default:{
                chooseActProcess();
            }
        }

    }

    void boyProcess() throws SQLException {
        showList();
        boyItem(IO.getInstance().getString(""));
        chooseActProcess();
    }

    void chooseActProcess() throws SQLException {
        String act = IO.getInstance().getString("1) Boy value \n"+"2) Show account info\n"+"3) Logout");
        switch (act){
            case "1":{
                boyProcess();
                break;
            }
            case "2":{
                System.out.println(
                        AuthController.getInstance().getUserInfo().toString()
                );
                chooseActProcess();
                break;
            }
            case "3":{
                AuthController.getInstance().logout();
                break;
            }
            default:{
                chooseActProcess();
                break;
            }
        }
    }
}

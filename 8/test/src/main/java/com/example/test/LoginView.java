package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginView {
    @FXML private Text error;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML protected void login(ActionEvent event) {

        try{
//            AuthenticationController.login(username,passsword);
        }catch (Exception e){

        }
    }

    @FXML protected void goToRegister(ActionEvent event) {
        ScreenController.getInstance().activate("register");
    }
}

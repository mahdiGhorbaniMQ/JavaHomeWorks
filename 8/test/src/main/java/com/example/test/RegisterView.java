package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterView {
    @FXML private Text error;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;


    @FXML protected void register(ActionEvent event) {

        try{
//            AuthenticationController.register(,username,passsword);
        }catch (Exception e){

        }
    }

    @FXML protected void goToLogin(ActionEvent event) {
        ScreenController.getInstance().activate("home");
    }


}

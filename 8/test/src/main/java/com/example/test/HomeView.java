package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeView {
    @FXML private Text firstNameTxt;
    @FXML private Text lastNameTxt;
    @FXML private Text emailTxt;
    @FXML private Text usernameTxt;

    @FXML protected void signOut(ActionEvent event) {
        ScreenController.getInstance().activate("login");
    }
    @FXML
    public void initialize() {
        firstNameTxt.setText("mahdi");
        lastNameTxt.setText("ghorbani");
        emailTxt.setText("mahdi@gmail.com");
        usernameTxt.setText("mahdi.123");
    }
}

package com.example.test.view;

import com.example.test.AuthController;
import com.example.test.MySQL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class HomeView {

    @FXML private Text nameTxt;
    @FXML private Text emailTxt;
    @FXML private Text usernameTxt;

    @FXML protected void signOut(ActionEvent event) {
        AuthController.getInstance().signOut();
        ScreenController.getInstance().activate("login");
    }
    @FXML protected void deleteAccount(ActionEvent event) throws SQLException {
        try {
            AuthController.getInstance().deleteAccount();
            ScreenController.getInstance().activate("login");
        }catch (Exception ignored){

        }finally {
            MySQL.getInstance().close();
        }
    }
    public HomeView() {
        Platform.runLater(() -> {
            nameTxt.setText(
                    AuthController.getInstance().getUserInfo().getName()
            );
            emailTxt.setText(
                    AuthController.getInstance().getUserInfo().getEmail()
            );
            usernameTxt.setText(
                    AuthController.getInstance().getUserInfo().getUsername()
            );
        });
    }
}

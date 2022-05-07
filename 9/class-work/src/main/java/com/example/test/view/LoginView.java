package com.example.test.view;

import com.example.test.AuthController;
import com.example.test.AuthException;
import com.example.test.MySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class LoginView {
    @FXML private Text error;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML protected void login(ActionEvent event) throws SQLException {

        try{
            AuthController.getInstance().login(
                    usernameField.getText(),
                    passwordField.getText()
            );
            ScreenController.getInstance().activate("home");
        } catch (SQLException e) {
            error.setText("Error: SQL Error!");
        } catch (AuthException e) {
            error.setText(e.getMessage());
        } finally {
            usernameField.setText("");
            passwordField.setText("");
            MySQL.getInstance().close();
        }
    }

    @FXML protected void goToRegister(ActionEvent event) {
        ScreenController.getInstance().activate("register");
    }
}

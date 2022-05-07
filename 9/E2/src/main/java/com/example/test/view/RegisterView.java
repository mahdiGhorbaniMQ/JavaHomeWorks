package com.example.test.view;

import com.example.test.AuthController;
import com.example.test.AuthException;
import com.example.test.MySQL;
import com.example.test.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class RegisterView {
    @FXML private Text error;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;


    @FXML protected void register(ActionEvent event) throws SQLException {

        try{
            AuthController.getInstance().register(
                    new User()
                            .setName(nameField.getText())
                            .setEmail(emailField.getText())
                            .setUsername(usernameField.getText())
                            .setPassword(passwordField.getText())
            );
            ScreenController.getInstance().activate("home");
        } catch (SQLException e) {
            error.setText("Error: SQL Error!");
        } catch (AuthException e) {
            error.setText(e.getMessage());
        } finally {
            nameField.setText("");
            emailField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            MySQL.getInstance().close();
        }

    }

    @FXML protected void goToLogin(ActionEvent event) {
        ScreenController.getInstance().activate("login");
    }


}

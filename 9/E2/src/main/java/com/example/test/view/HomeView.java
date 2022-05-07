package com.example.test.view;

import com.example.test.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class HomeView {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private Text usernameTxt;
    @FXML private Text error;

    @FXML protected void signOut(ActionEvent event) {
        AuthController.getInstance().signOut();
        ScreenController.getInstance().activate("login");
    }
    @FXML protected void update(ActionEvent event) throws SQLException {
        try {
            if(UserDAO.getInstance().findByEmail(emailField.getText()).orElse(null) != null)
                throw new AuthException("Error: Email is already taken!");

            AuthController.getInstance().getUserInfo().setName(
                    nameField.getText()
            );
            AuthController.getInstance().getUserInfo().setEmail(
                    emailField.getText()
            );
            UserDAO.getInstance().save(
                    AuthController.getInstance().getUserInfo()
            );
            error.setText("Ok!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (AuthException e) {
            error.setText(e.getMessage());
        } finally {
            MySQL.getInstance().close();
        }
    }
    public HomeView() {
        Platform.runLater(() -> {
            nameField.setText(
                    AuthController.getInstance().getUserInfo().getName()
            );
            emailField.setText(
                    AuthController.getInstance().getUserInfo().getEmail()
            );
            usernameTxt.setText(
                    AuthController.getInstance().getUserInfo().getUsername()
            );
        });
    }
}

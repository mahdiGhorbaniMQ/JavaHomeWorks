package com.example.test;

import com.example.test.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class EmployeeView {

    @FXML private TextField nameField;
    @FXML private TextField jobTitleField;
    @FXML private TextField staffField;
    @FXML private TextField salaryField;
    @FXML private TextField experienceField;
    @FXML private Text error;


    @FXML protected void add(ActionEvent event) throws SQLException {
        try {
            EmployeeController.getInstance().add(
              new Employee(
                      nameField.getText(),
                      experienceField.getText(),
                      staffField.getText(),
                      salaryField.getText(),
                      jobTitleField.getText()
              )
            );
            error.setText("Ok!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            MySQL.getInstance().close();
        }
    }
}

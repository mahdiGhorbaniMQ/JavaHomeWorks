package com.example.e1;

import com.example.e1.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeView {

    @FXML private TextField nameField;
    @FXML private TextField jobTitleField;
    @FXML private TextField staffField;
    @FXML private TextField salaryField;
    @FXML private TextField experienceField;
    @FXML private Text error;
    @FXML private FlowPane container ;

    private List<Label> labels ;

    public void initialize() {
        labels = new ArrayList<>();
        Thread thread = new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        EmployeeController.getInstance().getAll().forEach(employee -> {
                            Label label = new Label(employee.toString());
                            labels.add(label);
                            container.getChildren().removeAll();
                            container.getChildren().add(label);
                        });
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            MySQL.getInstance().close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        thread.start();
    }

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

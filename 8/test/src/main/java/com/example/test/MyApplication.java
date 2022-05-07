package com.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                MyApplication.class.getResource("login-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        ScreenController.getInstance().start(scene);
        setScreens();

        stage.setTitle("My Application");
        stage.setScene(scene);
        stage.show();
    }

    private void setScreens() throws IOException {
        ScreenController.getInstance().addScreen(
                "register",
                FXMLLoader.load(Objects.requireNonNull(
                        getClass().getResource("register-view.fxml")
                ))
        );
        ScreenController.getInstance().addScreen(
                "login",
                FXMLLoader.load(Objects.requireNonNull(
                        getClass().getResource("login-view.fxml")
                ))
        );
        ScreenController.getInstance().addScreen(
                "home",
                FXMLLoader.load(Objects.requireNonNull(
                        getClass().getResource("home-view.fxml")
                ))
        );
    }

    public static void main(String[] args) {
        launch();
    }
}
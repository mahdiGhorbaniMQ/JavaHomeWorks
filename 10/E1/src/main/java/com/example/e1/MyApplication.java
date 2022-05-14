package com.example.e1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                MyApplication.class.getResource("employee-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("My Application");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        FileInputStream fileInputStream =
                                new FileInputStream("src/main/java/com/example/e1/log.txt");
                        Scanner scanner = new Scanner(fileInputStream);
                        while (scanner.hasNextLine()){
                            System.out.println(scanner.hasNextLine());
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();
        launch();
    }
}
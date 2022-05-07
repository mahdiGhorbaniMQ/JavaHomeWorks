package com.example.test.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;

public class ScreenController {

    private ScreenController(){}
    private static final ScreenController instance = new ScreenController();
    public static ScreenController getInstance() {
        return instance;
    }

    private final HashMap<String, FXMLLoader> screenMap = new HashMap<>();
    private Scene main;

    public void start(Scene main) {
        if (this.main == null)
          this.main = main;
    }
    public void addScreen(String name, FXMLLoader fxmlLoader){
        screenMap.put(name, fxmlLoader);
    }

    public void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name) {
        try {
            main.setRoot( screenMap.get(name).load() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
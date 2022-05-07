package com.example.test;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController {

    private ScreenController(){}
    private static final ScreenController instance = new ScreenController();
    public static ScreenController getInstance() {
        return instance;
    }


    private final HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    protected void start(Scene main) {
        if (this.main == null)
          this.main = main;
    }
    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}
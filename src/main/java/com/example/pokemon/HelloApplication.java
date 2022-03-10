package com.example.pokemon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ventana1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 663, 400);
        stage.setTitle("ESCOGE POKEMON");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
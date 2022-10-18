package com.example.assignment1gc200495149;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("weight-data-table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Weight Data");
        stage.setScene(scene);
        stage.show();
        Workout deleteLater = new Workout("chest","Chin up",47.50,8);
        System.out.println(deleteLater.toString());
        System.out.println(deleteLater.getExerciseName());
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Завантаження FXML файлу
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Встановлення сцени та заголовку
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Підключення CSS стилів
        String css = getClass().getResource("/com/example/converter/style.css").toExternalForm();
        scene.getStylesheets().add(css);
    }



    public static void main(String[] args) {
        launch();
    }
}
package converter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Створення елементів інтерфейсу
        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        Label fromLabel = new Label("From Currency:");
        ComboBox<String> fromCurrency = new ComboBox<>();
        fromCurrency.getItems().addAll("USD", "EUR", "UAH");
        fromCurrency.setValue("USD");

        Label toLabel = new Label("To Currency:");
        ComboBox<String> toCurrency = new ComboBox<>();
        toCurrency.getItems().addAll("USD", "EUR", "UAH");
        toCurrency.setValue("EUR");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");

        // Логіка конвертації
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromCurrency.getValue();
                String to = toCurrency.getValue();
                double result = convertCurrency(amount, from, to);
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount.");
            }
        });

        // Розміщення елементів у GridPane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(resultLabel, 1, 4);

        grid.setAlignment(Pos.CENTER);

        // Сцена
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Проста логіка конвертації
        double conversionRate = 1;

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            conversionRate = 0.97;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("UAH")) {
            conversionRate = 42.31;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            conversionRate = 1.03;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("UAH")) {
            conversionRate = 43.34;
        } else if (fromCurrency.equals("UAH") && toCurrency.equals("USD")) {
            conversionRate = 0.024;
        } else if (fromCurrency.equals("UAH") && toCurrency.equals("EUR")) {
            conversionRate = 0.023;
        }

        return amount * conversionRate;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

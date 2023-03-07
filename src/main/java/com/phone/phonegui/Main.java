package com.phone.phonegui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * This is the main class that shows both the phone and the calculator.
 */
public class Main extends Application {
    private CalculatorDisplay calculator = new CalculatorDisplay();
    private PhoneDisplay phone = new PhoneDisplay();
    /**
     * This is the entry point into the application.
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        root.getChildren().addAll(calculator, phone);
        phone.getSwitchDisplayLabel().setOnMouseClicked(this::showCalculator);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }


    private void showCalculator(MouseEvent event) {

    }
}

package com.phone.phonegui;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;

/**
 * This is the main class that shows both the phone and the calculator.
 */
public class Main extends Application {
    StackPane root;
    private CalculatorDisplay calculator;
    private PhoneDisplay phone;

    public Main()
    {
        root = new StackPane();
        calculator = new CalculatorDisplay();
        phone = new PhoneDisplay();
    }
    /**
     * This is the entry point into the application.
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        Loading loadingLabel = new Loading();
        root.getChildren().addAll(calculator, phone, loadingLabel);
        phone.getSwitchDisplayLabel().setOnMouseClicked(this::showCalculator);
        calculator.getSwitchDisplayLabel().setOnMouseClicked(this::showPhone);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        initialise(loadingLabel);
    }

    private void initialise(Pane pane)
    {
        calculator.moveToLeft();
        fadeOutAndRemove(pane);

    }

    private void fadeOutAndRemove(Pane pane) {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), pane);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
        ft.setOnFinished(x -> root.getChildren().remove(pane));     // remove the pa
    }

    private void showCalculator(MouseEvent event)
    {
        phone.moveToRight();
        calculator.moveToOriginal();
    }

    private void showPhone(MouseEvent event)
    {
        calculator.moveToLeft();
        phone.moveToOriginal();
    }
}

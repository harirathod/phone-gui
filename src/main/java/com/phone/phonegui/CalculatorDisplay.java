package com.phone.phonegui;

import javafx.animation.TranslateTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class displays the Calculator. It has a switch button on its right-side.
 */
public class CalculatorDisplay extends DisplayWithKeypad {
    private BorderPane calculator;

    /**
     * Initialise fields and call the construction method.
     */
    public CalculatorDisplay()
    {
        super();
        switchDisplayLabel.setText("<");
        calculator = new BorderPane();
        createCalculator();
    }

    /**
     * Construct the calculator display.
     */
    private void createCalculator()
    {
        GridPane keypad = new GridPane();
        createKeypad(keypad);

        BorderPane display = new BorderPane();
        display.getStyleClass().add("display");
        display.setCenter(displayLabel);
        displayLabel.getStyleClass().add("display-label");

        VBox switchContainer = new VBox(switchDisplayLabel);
        switchContainer.getStyleClass().add("switch-container");
        switchContainer.setMaxHeight(Double.MAX_VALUE);
        switchDisplayLabel.getStyleClass().add("switch");

        calculator.setTop(display);
        calculator.setCenter(keypad);
        calculator.setRight(switchContainer);
        calculator.getStyleClass().add("calculator");
        this.setCenter(calculator);
    }

    /**
     * Create the keypad and keypad buttons.
     * @param grid The grid, in which to add the keypad buttons.
     */
    private void createKeypad(GridPane grid)
    {
        if (grid == null) return;
        VBox one = new VBox();
        one.getChildren().add(new Label("1"));
        VBox two = new VBox();
        two.getChildren().addAll(new Label("2"));
        VBox three = new VBox();
        three.getChildren().addAll(new Label("3"));
        VBox four = new VBox();
        four.getChildren().addAll(new Label("4"));
        VBox five = new VBox();
        five.getChildren().addAll(new Label("5"));
        VBox six = new VBox();
        six.getChildren().addAll(new Label("6"));
        VBox sev = new VBox();
        sev.getChildren().addAll(new Label("7"));
        VBox eight = new VBox();
        eight.getChildren().addAll(new Label("8"));
        VBox nine = new VBox();
        nine.getChildren().addAll(new Label("9"));
        VBox zero = new VBox();
        zero.getChildren().addAll(new Label("0"));

        List<VBox> numbers = new ArrayList<>();
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(sev);
        numbers.add(eight);
        numbers.add(nine);
        numbers.add(zero);
        // add event listener so when a keypad button is clicked, update the displayLabel with the tnumber in the
        // keypad button clicked
        for(VBox vbox : numbers) {
            Label label = (Label) vbox.getChildren().get(vbox.getChildren().size() - 1);
            vbox.setOnMouseClicked(event -> displayLabel.setText(displayLabel.getText() + label.getText()));
        }

        // add keypad buttons to the grid, and add an appropriate class to each
        grid.addRow(0, sev, eight, nine);
        grid.addRow(1, four, five, six);
        grid.addRow(2, one, two, three);
        for(Node node : grid.getChildren()) {
            node.getStyleClass().add("keypad-button");
        }
    }


}

package com.phone.phonegui;

import javafx.animation.TranslateTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;

import java.util.ArrayList;
import java.util.Collections;
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
        Label one = new Label("1");
        Label two = new Label("2");
        Label three = new Label("3");
        Label four = new Label("4");
        Label five = new Label("5");
        Label six = new Label("6");
        Label seven = new Label("7");
        Label eight = new Label("8");
        Label nine = new Label("9");
        Label zero = new Label("0");
        Label decimal = new Label(".");
        Label equals = new Label("=");
        Label plus = new Label("+");
        Label minus = new Label("-");
        Label ac = new Label("AC");

        List<Label> numbers = new ArrayList<>();
        Collections.addAll(numbers, one, two, three, four, five, six, seven, eight, nine, zero);

        // add event listener so when a keypad button is clicked, update the displayLabel with the number in the
        // keypad button clicked
        for(Label label : numbers) {
            label.setOnMouseClicked(event -> displayLabel.setText(displayLabel.getText() + label.getText()));
        }

        // add keypad buttons to the grid, and add an appropriate class to each
        grid.addRow(0, seven, eight, nine);
        grid.addRow(1, four, five, six);
        grid.addRow(2, one, two, three);
        grid.add(zero, 0, 3, 5, 3);
        grid.add(decimal, 2, 3);
        grid.add(equals, 3, 3);
        grid.add(ac, 3, 0);
        grid.add(plus, 3, 1);
        grid.add(minus, 3, 2);

        for(Node node : grid.getChildren()) {
            node.getStyleClass().add("keypad-button");
        }
    }


}

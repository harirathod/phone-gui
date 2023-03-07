package com.phone.phonegui;

import javafx.animation.TranslateTransition;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main class that display the phone and the keypad.
 */
public class PhoneDisplay extends BorderPane {

    private Label displayLabel;
    private Label switchDisplays;
    private BorderPane phone;

    public PhoneDisplay()
    {
        displayLabel = new Label("");
        switchDisplays = new Label("<");
        phone = new BorderPane();
    }

    public void createPhoneDisplay() {
        GridPane keypad = new GridPane();
        createPhone(keypad);

        BorderPane display = new BorderPane();
        display.getStyleClass().add("display");
        display.setCenter(displayLabel);
        displayLabel.getStyleClass().add("display-label");

        VBox switchContainer = new VBox(switchDisplays);
        switchContainer.getStyleClass().add("switch-container");
        switchContainer.setMaxHeight(Double.MAX_VALUE);
        switchDisplays.setOnMouseClicked(this::hideDisplay);
        switchDisplays.getStyleClass().add("switch");

        phone.setTop(display);
        phone.setCenter(keypad);
        phone.setLeft(switchContainer);
        phone.getStyleClass().add("phone");
        this.setCenter(phone);
    }

    private void createPhone(GridPane grid)
    {
        VBox one = new VBox();
        one.getChildren().add(new Label("1"));
        VBox two = new VBox();
        two.getChildren().addAll(new Label("ABC"), new Label("2"));
        VBox three = new VBox();
        three.getChildren().addAll(new Label("DEF"), new Label("3"));
        VBox four = new VBox();
        four.getChildren().addAll(new Label("GHI"), new Label("4"));
        VBox five = new VBox();
        five.getChildren().addAll(new Label("JKL"), new Label("5"));
        VBox six = new VBox();
        six.getChildren().addAll(new Label("MNO"),new Label("6"));
        VBox sev = new VBox();
        sev.getChildren().addAll(new Label("PQRS"), new Label("7"));
        VBox eight = new VBox();
        eight.getChildren().addAll(new Label("TUV"), new Label("8"));
        VBox nine = new VBox();
        nine.getChildren().addAll(new Label("WXYZ"),new Label("9"));
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
        // add event listener so when a keypad button is clicked, update the displayLabel with the text/number in the
        // keypad button clicked
        for(VBox vbox : numbers) {
            Label label = (Label) vbox.getChildren().get(vbox.getChildren().size() - 1);
            vbox.setOnMouseClicked(event -> displayLabel.setText(displayLabel.getText() + label.getText()));
        }

        VBox ast = new VBox();
        ast.getChildren().add(new Label("*"));
        ast.setId("asterisk-button");
        ast.setOnMouseEntered(this::reverseDisplayLabel);
        ast.setOnMouseExited(this::reverseDisplayLabel);

        VBox hash = new VBox();
        hash.getChildren().addAll(new Label("#"));
        hash.setOnMouseClicked(event -> displayLabel.setText(""));

        grid.addRow(0, one, two, three);
        grid.addRow(1, four, five, six);
        grid.addRow(2, sev, eight, nine);
        grid.addRow(3, ast, zero, hash);
        for(Node node : grid.getChildren()) {
            node.getStyleClass().add("keypad-button");
        }
    }

    /**
     * Reverse the text in the display label.
     * @param mouseEvent The event generated when the mouse is dragged over.
     */
    private void reverseDisplayLabel(MouseEvent mouseEvent) {
        String temp = "";
        for (int i = displayLabel.getText().length() - 1; i >= 0; i--) {
            temp += displayLabel.getText().substring(i, i + 1);
        }
        displayLabel.setText(temp);
    }

    /**
     * Change the display from the phone to the calculator.
     */
    private void hideDisplay(MouseEvent event)
    {
        TranslateTransition hidePhone = new TranslateTransition(Duration.millis(500), phone);
        hidePhone.setToX(-phone.getWidth());
        hidePhone.play();
    }
}
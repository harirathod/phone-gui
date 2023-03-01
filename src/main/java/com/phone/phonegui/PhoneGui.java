package com.phone.phonegui;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This is the main class that display the phone and the keypad.
 */
public class PhoneGui extends Application {

    private Label displayLabel;

    public PhoneGui()
    {
        displayLabel = new Label("");
        displayLabel.setId("display-label");
    }

    /**
     * The main method.
     * @param args Leave blank.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * The entry point to our application.
     * @param stage The main stage (i.e., the main window) of our application, that this class will be using.
     */
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        createPhone(grid);

        BorderPane display = new BorderPane();
        display.getStyleClass().add("display");
        display.setCenter(displayLabel);

        Pane phone = new VBox(display, grid);
        phone.getStyleClass().add("phone");
        root.setCenter(phone);
        Scene scene = new Scene(root, 350, 500);
        scene.getStylesheets().add("/style.css");
        stage.setScene(scene);
        stage.setTitle("Phone");
        stage.show();
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

        VBox ast = new VBox();
        ast.getChildren().addAll(new Label("*"));
        ast.getChildren().get(0).setId("asterisk");
        VBox zero = new VBox();
        zero.getChildren().addAll(new Label("0"));
        VBox hash = new VBox();
        hash.getChildren().addAll(new Label("#"));

        grid.addRow(0, one, two, three);
        grid.addRow(1, four, five, six);
        grid.addRow(2, sev, eight, nine);
        grid.addRow(3, ast, zero, hash);
        for(Node node : grid.getChildren()) {
            node.getStyleClass().add("keypad");
        }
    }
}
package com.phone.phonegui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Loading extends BorderPane {

    protected Label loadingLabel;
    protected Text text;

    public Loading()
    {
        text = new Text();
        loadingLabel = new Label();
        createLoadingScreen();
    }

    private void createLoadingScreen()
    {
        text.setText("Loading...");
        text.setFont(Font.font("Open Sans", 32));
        text.setFill(Color.WHITE);
        loadingLabel.setGraphic(text);
        this.setCenter(loadingLabel);

        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setBackground(Background.fill(Color.BLACK));
    }
}

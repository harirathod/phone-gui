package com.phone.phonegui;

import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

public abstract class DisplayWithKeypad extends BorderPane {
    protected Label displayLabel;
    protected Label switchDisplayLabel;     // button to switch displays

    public DisplayWithKeypad()
    {
        displayLabel = new Label("");
        switchDisplayLabel = new Label("");
    }

    /**
     * Move the display to the left by using translation transitions.
     * @param event The action event associated with this transitions.
     */
    protected void moveToLeft(MouseEvent event)
    {
        TranslateTransition hideThis = new TranslateTransition(Duration.millis(500), this);
        hideThis.setToX(-this.getWidth());
        hideThis.play();
    }

    /**
     * Move the display to the left by using translation transitions.
     * @param event The action event associated with this transitions.
     */
    protected void moveToRight(MouseEvent event)
    {
        TranslateTransition hideThis = new TranslateTransition(Duration.millis(500), this);
        hideThis.setToX(this.getWidth());
        hideThis.play();
    }

    /**
     * Get the label that the user can click to switch displays.
     * @return The label that the user can click to switch displays.
     */
    public Label getSwitchDisplayLabel()
    {
        return switchDisplayLabel;
    }
}

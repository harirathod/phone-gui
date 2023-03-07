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
     */
    public void moveToLeft()
    {
        TranslateTransition moveLeft = new TranslateTransition(Duration.millis(500), this);
        moveLeft.setToX(-this.getWidth());
        moveLeft.play();
    }

    /**
     * Move the display to the left by using translation transitions.
     */
    public void moveToRight()
    {
        TranslateTransition moveRight = new TranslateTransition(Duration.millis(500), this);
        moveRight.setToX(this.getWidth());
        moveRight.play();
    }

    /**
     * Move the display to its original position, in the center of the scene.
     */
    public void moveToOriginal()
    {
        TranslateTransition moveOriginal = new TranslateTransition(Duration.millis(500), this);
        moveOriginal.setToX(0);
        moveOriginal.play();
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

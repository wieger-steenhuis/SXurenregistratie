package nl.programit.urenregistratiegui.fxcomponents;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * Created by udr013 on 4-3-2016.
 */
public class MyDatePicker extends DatePicker {

    public MyDatePicker(){
        super();
        setMaxWidth(300);
        setStyle("-fx-border-color: #5b5b5b;-fx-background-color: rgba(225, 225, 225, 0.90);-fx-font: 20px italic;" +
                "-fx-prompt-text-fill: #7b7b7b; -fx-text-fill: #000000;-fx-background-radius: 7; -fx-border-radius: 7");

    }

    public MyDatePicker(LocalDate localDate) {

        super(localDate);
        setStyle("-fx-border-color: #ec008e;-fx-background-color: rgba(225, 225, 225, 0.90);-fx-font: 20 italic;" +
                "-fx-prompt-text-fill: #7b7b7b; -fx-text-fill: #000000;-fx-background-radius: 7; -fx-border-radius: 7");

    }

}

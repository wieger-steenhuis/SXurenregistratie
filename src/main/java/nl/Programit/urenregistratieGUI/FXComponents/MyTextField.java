package nl.programit.urenregistratiegui.fxcomponents;

import javafx.scene.control.TextField;

/**
 * Created by udr013 on 6-2-2016.
 */
public class MyTextField extends TextField {
    public MyTextField(String prevText){
        setPromptText(prevText);
        setMaxWidth(300);
        setStyle("-fx-border-color: #5b5b5b;-fx-background-color: rgba(225, 225, 225, 0.90);-fx-font: 18px italic;" +
                "-fx-prompt-text-fill: #7b7b7b; -fx-text-fill: #000000;-fx-background-radius: 7; -fx-border-radius: 7");
    }
    public MyTextField(String prevText, double width){
        this(prevText);
        setMaxWidth(width);
    }
}

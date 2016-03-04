package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.control.PasswordField;


/**
 * Created by udr013 on 6-2-2016.
 */
public class MyPasswordField extends PasswordField {
    public MyPasswordField(String prevText){
        setPromptText(prevText);
        setMaxWidth(300);
        setStyle("-fx-font: 22 italic; -fx-text-fill: #000000");
    }
    public MyPasswordField(String prevText, double width){
        this(prevText);
        setMaxWidth(width);

    }
}

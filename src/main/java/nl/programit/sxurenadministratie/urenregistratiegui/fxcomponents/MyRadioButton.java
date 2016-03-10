package nl.programit.sxurenadministratie.urenregistratiegui.fxcomponents;

import javafx.scene.control.RadioButton;

/**
 * Created by udr013 on 10-3-2016.
 */
public class MyRadioButton extends RadioButton {

    public MyRadioButton(){
        super();
        setStyle("-fx-font: 16 italic;-fx-mark-highlight-color: #ec008e ;-fx-mark-color: #ec008e;" +
                "-fx-focus-color:#ec008e; -fx-outer-border:#ec008e");
    }
    public MyRadioButton(String text){
        this();
        setText(text);

    }
}

package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.control.TextField;

/**
 * Created by udr013 on 6-2-2016.
 */
public class MyTextField extends TextField {
    public MyTextField(String prevText){
        setPromptText(prevText);
        //setMaxWidth(300);
        //setStyle("-fx-font: 22 italic; -fx-text-fill: #000000");
    }
    public MyTextField(String prevText, double width){
        this(prevText);
        setMaxWidth(width);
    }
}

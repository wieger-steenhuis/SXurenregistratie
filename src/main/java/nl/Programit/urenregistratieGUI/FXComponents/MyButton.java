package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * Created by udr013 on 6-2-2016.
 */
public  class MyButton extends Button{
    public MyButton(String a){
        setText(a);
        setTextFill( Color.WHITE );
        minWidth(200.0);
        setStyle( "-fx-font: 22 italic; -fx-base: #000000; " );

    }
    public MyButton(String a, Pos b){
        this(a);
        setAlignment(b);


    }

}

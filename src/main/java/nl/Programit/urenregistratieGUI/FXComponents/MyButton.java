package nl.programit.urenregistratiegui.fxcomponents;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * Created by udr013 on 6-2-2016.
 *
 */
public  class MyButton extends Button{

    public MyButton(){
        super();
    }

    public MyButton(String a){
        setText(a);
        setTextFill( Color.WHITE );
        setMinWidth(180.0);

        setStyle( "-fx-font: 18px italic; -fx-base: #ec008e;-fx-background-radius: 7; -fx-border-color: deeppink; " +
                "-fx-progress-color: deeppink; -fx-border-radius: 7" );

    }

    public MyButton(String a, Pos b){
        this(a);
        setAlignment(b);
    }

    public MyButton(String text, Node graphic) {
        super(text, graphic);

    }

}

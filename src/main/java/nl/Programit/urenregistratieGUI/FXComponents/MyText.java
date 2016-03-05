package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Created by udr013 on 4-3-2016.
 */
public class MyText extends Text {

    public MyText(){
        super();
    }

    public MyText(String text) {
        this();
        setText(text);
    }

    public MyText(double x, double y, String text) {
        this(text);
        setX(x);
        setY(y);
    }

    public MyText(String text, Color color){
        this(text);
        setFill(color);
    }

}

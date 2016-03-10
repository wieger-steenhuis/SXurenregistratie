package nl.programit.sxurenadministratie.gui.fxcomponents;

import javafx.scene.control.Button;

public class NumberButton extends Button{
     private int number;
    public NumberButton(int number){
        super(""+number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

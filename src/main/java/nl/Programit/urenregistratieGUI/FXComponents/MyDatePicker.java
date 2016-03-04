package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * Created by udr013 on 4-3-2016.
 */
public class MyDatePicker extends DatePicker {

    public MyDatePicker(){
        super();
        setMaxWidth(300);

    }

    public MyDatePicker(LocalDate localDate) {
        super(localDate);
    }
}

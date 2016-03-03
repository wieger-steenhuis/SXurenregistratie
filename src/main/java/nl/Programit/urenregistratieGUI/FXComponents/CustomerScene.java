package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieModel1.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class CustomerScene {

    public static Scene getCustomerScene(Person person) {

        Customer customer = (Customer)person;
        Text welkomText = new Text("Welkom Klant " + customer.getFirstName());
        VBox elements = new VBox(welkomText);
        Scene customerScene = new Scene(elements);
        return customerScene;
    }

}

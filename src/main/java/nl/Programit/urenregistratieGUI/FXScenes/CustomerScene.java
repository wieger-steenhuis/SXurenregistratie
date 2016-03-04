package nl.Programit.urenregistratieGUI.FXScenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieGUI.FXComponents.MyButton;
import nl.Programit.urenregistratieGUI.Main;
import nl.Programit.urenregistratieModel1.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class CustomerScene {

    public static Scene getCustomerScene(Person person) {

        Customer customer = (Customer)person;

        Text welkomText = new Text("Welkom Klant: " + customer.getFirstName());

        MyButton logout = Main.getLogout();

        VBox elements = new VBox(welkomText);
        elements.setAlignment(Pos.CENTER);
        VBox menu = new VBox(30,logout);

        HBox fullbox = new HBox(menu,elements);
        fullbox.setFillHeight(true);

        elements.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fullbox);
        return scene;
    }

}

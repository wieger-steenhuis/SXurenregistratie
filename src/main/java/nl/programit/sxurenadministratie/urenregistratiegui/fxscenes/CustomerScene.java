package nl.programit.sxurenadministratie.urenregistratiegui.fxscenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.programit.sxurenadministratie.urenregistratiegui.fxcomponents.MyButton;
import nl.programit.sxurenadministratie.urenregistratiegui.Main;
import nl.programit.administratie.*;

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

        //centre Vbox for "sessie"  with it's components
        VBox sessieBox = new VBox(20);


        HBox fullbox = new HBox(menu,elements);
        fullbox.setFillHeight(true);

        elements.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fullbox);
        return scene;
    }

}

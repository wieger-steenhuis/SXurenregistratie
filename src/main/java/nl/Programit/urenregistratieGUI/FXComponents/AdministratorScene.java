package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieModel1.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class AdministratorScene {

    public static Scene getAdministratorScene(Person person) {

         Administrator administrator= (Administrator)person;
        Text welkomText = new Text("Welkom " +administrator.getFirstName());
        VBox elements = new VBox(welkomText);
        Scene administratorScene = new Scene(elements);
        return administratorScene;
    }

}

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
public class AdministratorScene {

    public static Scene getAdministratorScene(Person person) {



        Administrator administrator= (Administrator)person;
        Text welkomText = new Text("Welkom Administrator: " +administrator.getFirstName());

        MyButton logout = Main.getLogout();

        VBox elements = new VBox(welkomText);
        VBox menu = new VBox(logout);
        HBox fullbox = new HBox(menu,elements);
        elements.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fullbox);
        return scene;
    }


}

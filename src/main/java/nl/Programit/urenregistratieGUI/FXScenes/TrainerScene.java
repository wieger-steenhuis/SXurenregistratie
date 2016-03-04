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
public class TrainerScene {

    public static Scene getTrainerScene(Person person) {



        Trainer trainer = (Trainer)person;
        Text welkomText = new Text("Welkom trainer: " + trainer.getFirstName());

        MyButton logout = Main.getLogout();

        VBox elements = new VBox(welkomText);
        VBox menu = new VBox(logout);
        HBox fullbox = new HBox(elements,menu);
        elements.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fullbox);
        return scene;
    }

}

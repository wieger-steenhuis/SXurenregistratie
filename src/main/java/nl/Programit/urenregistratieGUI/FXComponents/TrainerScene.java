package nl.Programit.urenregistratieGUI.FXComponents;

import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by udr013 on 3-3-2016.
 */
public class TrainerScene {

    public static Scene getScene()

    {

        Text welkomText = new Text("Welkom");
        VBox elements = new VBox(welkomText);
        Scene trainerScene = new Scene(elements);
        return trainerScene;
    }





}

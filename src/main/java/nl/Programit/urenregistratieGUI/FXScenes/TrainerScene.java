package nl.Programit.urenregistratieGUI.FXScenes;


import com.sun.javafx.menu.RadioMenuItemBase;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieGUI.FXComponents.MyButton;
import nl.Programit.urenregistratieGUI.Main;
import nl.Programit.administratie.*;
import nl.Programit.urenregistratieSessie.Session;

import javax.swing.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class TrainerScene {

    public static Scene getTrainerScene(Person person) {

        Trainer trainer = (Trainer)person;
        Text welkomText = new Text("Welkom trainer: " + trainer.getFirstName());

        MyButton logout = Main.getLogout();

        HBox welkom = new HBox(welkomText);
        VBox menu = new VBox(logout);

        //create Togglegroup to make only one Radiobutton selectable
        ToggleGroup sessies = new ToggleGroup();
        RadioButton sessie = new RadioButton("eerste sessie");
        sessie.setToggleGroup(sessies);
        RadioButton sessie1 = new RadioButton("Tweede sessie");
        sessie1.setToggleGroup(sessies);
        RadioButton sessie2 = new RadioButton("Derde sessie");
        sessie2.setToggleGroup(sessies);
        RadioButton sessie3 = new RadioButton("Vierde sessie");
        sessie3.setToggleGroup(sessies);

        //add all radiobuttons to a VBox with 30 spacing for it's elements, can't add Togglegroup as a whole!
        VBox sessionsToday = new VBox(30);
        sessionsToday.getChildren().addAll(sessie,sessie1,sessie2,sessie3);

        VBox centrebox = new VBox(welkom,sessionsToday);
        centrebox.setAlignment(Pos.CENTER);
        HBox fullbox = new HBox(menu,centrebox);
        //elements.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fullbox);
        return scene;
    }

}

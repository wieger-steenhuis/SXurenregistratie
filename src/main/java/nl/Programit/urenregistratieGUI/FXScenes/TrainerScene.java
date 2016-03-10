package nl.Programit.urenregistratieGUI.FXScenes;


import com.sun.javafx.menu.RadioMenuItemBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieGUI.FXComponents.MyButton;
import nl.Programit.urenregistratieGUI.FXComponents.MyRadioButton;
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
        MyRadioButton sessie = new MyRadioButton("eerste sessie");
        sessie.setAlignment(Pos.CENTER_LEFT);
        sessie.setToggleGroup(sessies);
        MyRadioButton sessie1 = new MyRadioButton("Tweede sessie");
        sessie1.setToggleGroup(sessies);
        MyRadioButton sessie2 = new MyRadioButton("Derde sessie");
        sessie2.setToggleGroup(sessies);
        MyRadioButton sessie3 = new MyRadioButton("Vierde sessie");
        sessie3.setToggleGroup(sessies);

        //add all radiobuttons to a VBox with 30 spacing for it's elements, can't add Togglegroup as a whole!
        VBox sessionsToday = new VBox(30);
        sessionsToday.setPadding(new Insets(30, 30, 30,30));
        sessionsToday.setStyle("-fx-background-color: rgba(221, 214, 214, 0.90);-fx-font: 20 italic;" +
                "-fx-background-radius: 7; -fx-border-radius: 7");
        sessionsToday.getChildren().addAll(sessie,sessie1,sessie2,sessie3);

        VBox centrebox = new VBox(menu,sessionsToday);

        menu.setAlignment(Pos.TOP_LEFT);
        sessionsToday.setAlignment(Pos.CENTER);
        //centrebox.setAlignment(Pos.CENTER);
        //VBox fullbox = new VBox(menu,centrebox);
        menu.setAlignment(Pos.TOP_LEFT);
        //fullbox.setAlignment(Pos.CENTER);
        //elements.setAlignment(Pos.CENTER);



        Image image = new Image("IMG_3242.jpg");
        ImageView imageSX = new ImageView();
        StackPane achtergrond2 = new StackPane(imageSX,centrebox);
        Scene scene = new Scene(achtergrond2);
        imageSX.setImage(image);
        imageSX.isPreserveRatio();
        imageSX.fitWidthProperty().bind(scene.widthProperty());
        imageSX.fitHeightProperty().bind(scene.heightProperty());

        return scene;
    }

}

package nl.programit.sxurenadministratie.gui.fxscenes;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyButton;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyDatePicker;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyRadioButton;
import nl.programit.sxurenadministratie.gui.Main;
import nl.programit.administratie.*;

import java.time.LocalDate;

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
        MyDatePicker datePicker = new MyDatePicker(LocalDate.now());
        MyButton findButton = new MyButton("vind");
        HBox findSession = new HBox(20,datePicker,findButton);
        findSession.setAlignment(Pos.CENTER);

        MyButton sessieInfoB = new MyButton("Info");
        MyButton sessieAproveB = new MyButton("Accoord");
        sessieAproveB.setStyle("-fx-font: 16 italic; -fx-base: #82BD02;-fx-background-radius: 7; -fx-border-radius: 7");
        HBox moreSession = new HBox(20,sessieInfoB,sessieAproveB);
        moreSession.setAlignment(Pos.CENTER);

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


        sessieAproveB.setOnAction(event -> {
            String aproved ="\u2713 ";

            if (sessies.getSelectedToggle().getClass() != null){
               // for (int intcount = 0; intcount < strArrtext.length; intcount++) {
               //     sessies.getToggles().g.settext("test");
                ((RadioButton)sessies.getSelectedToggle()).setText(aproved+((RadioButton)sessies.getSelectedToggle()).getText());
            }

        });

        //add all radiobuttons to a VBox with 30 spacing for it's elements, can't add Togglegroup as a whole!
        VBox sessionsToday = new VBox(30);

        sessionsToday.setPadding(new Insets(30, 30, 30,30));
        sessionsToday.setStyle("-fx-background-color: rgba(221, 214, 214, 0.90);-fx-font: 20 italic;" +
                "-fx-background-radius: 7; -fx-border-radius: 7");
        sessionsToday.getChildren().addAll(findSession,sessie,sessie1,sessie2,sessie3,moreSession);

        VBox centrebox = new VBox(menu,sessionsToday);

        menu.setAlignment(Pos.TOP_LEFT);
        menu.setPadding(new Insets(0,30,150,0));
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

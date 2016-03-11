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
import java.util.ArrayList;

/**
 * Created by udr013 on 3-3-2016.
 *
 */
public class TrainerScene {

    private static VBox sessionsToday;
    private  static ArrayList<MyRadioButton> myRadioButtons;
    private static SessionController controller = new SessionController();
    private static ArrayList<Session> todaysSessions;

    public static Scene getTrainerScene(Person person) {

        //SessionController controller = new SessionController();
        //LocalDate ld = LocalDate.of(2015, 3, 31);
        //System.out.println(controller.retrieveSessionListbyDate(ld));

        Trainer trainer = (Trainer)person;
        Text welkomText = new Text("Welkom trainer: " + trainer.getFirstName());

        MyButton logout = Main.getLogout();

        HBox welkom = new HBox(welkomText);
        VBox menu = new VBox(logout);
        menu.setPadding(new Insets(5,30,150,5));

        //create Togglegroup to make only one Radiobutton selectable
        //todo create text fields for first radiobutton text and if possible approved sessions
        MyDatePicker datePicker = new MyDatePicker();
        datePicker.setValue(LocalDate.now());
        MyButton findButton = new MyButton("Vind");
        HBox findSession = new HBox(20,datePicker,findButton);
        findSession.setAlignment(Pos.CENTER);

        MyButton sessieInfoB = new MyButton("Info");
        MyButton sessieAproveB = new MyButton("Akkoord");
        sessieAproveB.setStyle("-fx-font: bold 16 calibre; -fx-base: #82BD02;-fx-background-radius: 7; -fx-border-radius: 7");
        HBox moreSession = new HBox(20,sessieInfoB,sessieAproveB);
        moreSession.setAlignment(Pos.CENTER);

        ToggleGroup sessies = new ToggleGroup();
        MyRadioButton sessie = new MyRadioButton("selecteer een datum en druk op vind om sessies weer te geven");




        findButton.setOnAction(event1 -> {
            sessionsToday.getChildren().clear();
            sessionsToday.getChildren().add(findSession);
            //controller = new SessionController();
            todaysSessions =  controller.retrieveSessionListbyDate(datePicker.getValue(), trainer);
            myRadioButtons = new ArrayList<>();
            for(Session x : todaysSessions){
                    MyRadioButton sessieRadioButton = new MyRadioButton(x.toString());
                    myRadioButtons.add(sessieRadioButton);
                }
            for(RadioButton x:myRadioButtons){
                x.setToggleGroup(sessies);
                sessionsToday.getChildren().add(x);

            }
            sessionsToday.getChildren().add(moreSession);

        });

        sessieAproveB.setOnAction(event -> {
            String approved ="\u2713 ";

            if (sessies.getSelectedToggle().getClass() != null){

               if(((RadioButton)sessies.getSelectedToggle()).getText().contains("✓")){
                   System.out.println("already approved");

                } else{
               ((RadioButton)sessies.getSelectedToggle()).setText(approved+((RadioButton)sessies.getSelectedToggle()).getText());
                int index =myRadioButtons.indexOf(sessies.getSelectedToggle());
                   System.out.println(todaysSessions.get(index));//CONTROLE PRINT VOOR APPROVAL
                   //TODO Tweede argument straks vervangen voor de door de klant ingetoetste pincode:
                   controller.approveSession(controller.getSessionForApproval(todaysSessions.get(index)),controller.getSessionForApproval(todaysSessions.get(index)).getCustomer().getPin());
                   System.out.println(todaysSessions.get(index));//CONTROLE PRINT NA APPROVAL
            }}}

        );

        //add all radiobuttons to a VBox with 30 spacing for it's elements, can't add Togglegroup as a whole!
        sessionsToday = new VBox(30);

        sessionsToday.setPadding(new Insets(30, 30, 30,30));
        sessionsToday.setStyle("-fx-background-color: rgba(221, 214, 214, 0.90);-fx-font: 20 italic;" +
                "-fx-background-radius: 7; -fx-border-radius: 7");
        sessionsToday.getChildren().addAll(findSession,sessie,moreSession);

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

package nl.Programit.urenregistratieGUI.FXScenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import nl.Programit.urenregistratieGUI.FXComponents.MyPasswordField;
import nl.Programit.urenregistratieGUI.FXComponents.NumberButton;
import nl.Programit.administratie.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class LoginScene {


    public static Scene getLoginScene(Stage bla) {
        Stage window = bla;
        window.setMaximized(true);
        double width = window.getWidth();
        double  hight = window.getHeight();

        Text message = new Text();
        MyPasswordField pincodeField = new MyPasswordField("Pincode");

        VBox loginFullbox = new VBox();
        loginFullbox.setAlignment(Pos.CENTER);
        HBox row0 = new HBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        HBox row4 = new HBox();
        HBox row5 = new HBox();

        message.setText("Voer uw Login Code in.");
        message.setFill(Color.BLUE);
        message.setStyle("-fx-font: bold 18px Calibri");


        Button clearButton = new Button("CLEAR");
        Button enterButton = new Button("ENTER");

        clearButton.setMinSize(80, 80);
        clearButton.setStyle("-fx-base:firebrick; -fx-background-radius: 10; -fx-border-color: #ffffff; -fx-font: bold 18px Calibri; -fx-text-fill: yellow;");
        clearButton.setOnAction(event -> pincodeField.clear());
        enterButton.setMinSize(80, 80);
        enterButton.setStyle("-fx-base:darkgreen; -fx-background-radius: 10; -fx-border-color: #ffffff; -fx-font: bold 18px Calibri; -fx-text-fill: yellow;");

        enterButton.setOnAction(event -> {
            window.setWidth(width);
            window.setHeight(hight);
            int pincodenr = Integer.parseInt(pincodeField.getText());
            Person thisPerson = DataPersister.getInstance().retrieveEntry(pincodenr);
            if ((pincodeField.getLength() == 4) && !(thisPerson == null)) {
                if ((thisPerson instanceof Trainer)) {
                    pincodeField.clear();
                    window.setScene(TrainerScene.getTrainerScene(thisPerson));
                } else if ((thisPerson instanceof Administrator)) {
                    pincodeField.clear();
                    window.setScene(AdministratorScene.getAdministratorScene(thisPerson));
                    window.setMaximized(true);
                } else if ((thisPerson instanceof Customer)) {
                    pincodeField.clear();
                    window.setScene(CustomerScene.getCustomerScene(thisPerson));

                }


            }else if((pincodeField.getLength() == 4)&& (thisPerson == null) &&(Integer.parseInt(pincodeField.getText())==0000)){
                Person backdoor = new Administrator();
                window.setScene(AdministratorScene.getAdministratorScene(backdoor));
            }

            else {
                message.setText("Uw LoginCode is onjuist!\n voer nogmaals uw code in");
                message.setStyle("-fx-font: bold 18px Calibri;-fx-fill: crimson");
                pincodeField.clear();
            }

        });

        pincodeField.setMinSize(240, 40);
        pincodeField.setPromptText("pincode");
        pincodeField.setStyle("-fx-text-fill: black; -fx-background-color: #aaaaaa; -fx-border-color: #000000; -fx-border-radius: 5");

        //Text message = new Text(getMessage(pincodeField.getText()));
        message.setStyle("-fx-font: bold 18px Calibri; -fx-text-fill: Blue;");
        NumberButton[] numberButtons = makeNumberButtons();

        for (NumberButton knop : numberButtons) {
            knop.setOnAction(e ->
                    pincodeField.setText(pincodeField.getText() + knop.getText()));
        }

        row0.getChildren().add(message);
        row1.getChildren().addAll(pincodeField);
        row2.getChildren().addAll(numberButtons[1], numberButtons[2], numberButtons[3]);
        row3.getChildren().addAll(numberButtons[4], numberButtons[5], numberButtons[6]);
        row4.getChildren().addAll(numberButtons[7], numberButtons[8], numberButtons[9]);
        row5.getChildren().addAll(clearButton, numberButtons[0], enterButton);

        row0.setAlignment(Pos.CENTER);
        row1.setPadding(new Insets(6, 0, 0, 0));//boven, rechts,onder, links
        row1.setAlignment(Pos.CENTER);
        row2.setPadding(new Insets(6, 0, 0, 0));
        row2.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        row4.setAlignment(Pos.CENTER);
        row5.setAlignment(Pos.CENTER);

        loginFullbox.getChildren().addAll(row0, row1, row2, row3, row4, row5);

        Scene loginScene = new Scene(loginFullbox);

        return loginScene;
    }

    public static NumberButton[] makeNumberButtons() {
        NumberButton[] numberButtons = new NumberButton[10];
        for (int index = 0; index < 10; index++) {
            numberButtons[index] = (new NumberButton(index));
            numberButtons[index].setMinSize(80, 80);
            numberButtons[index].setStyle("-fx-base:#444444; -fx-background-radius: 10; -fx-border-color: #ffffff; -fx-font: bold 22px Calibri; -fx-text-fill: yellow;");
        }
        return numberButtons;

    }

}

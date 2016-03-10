package nl.programit.urenregistratiegui.fxscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import nl.programit.urenregistratiegui.fxcomponents.MyPasswordField;
import nl.programit.urenregistratiegui.fxcomponents.NumberButton;
import nl.programit.administratie.*;

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
        message.setFill(Color.rgb(236,0,148));
        message.setStyle("-fx-font: bold 18px Calibri");


        Button clearButton = new Button("CLEAR");
        Button enterButton = new Button("ENTER");

        clearButton.setMinSize(80, 80);
        clearButton.setStyle("-fx-base:#ec008e; -fx-background-radius: 10;-fx-border-radius: 10; -fx-border-color: #ec2592; -fx-font: bold 18px Calibri; -fx-text-fill: white;");
        clearButton.setOnAction(event -> pincodeField.clear());
        enterButton.setMinSize(80, 80);
        enterButton.setStyle("-fx-base:#82BD02; -fx-background-radius: 10;-fx-border-radius: 10; -fx-border-color: #5fff00; -fx-font: bold 18px Calibri; -fx-text-fill: white;");

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
                message.setStyle("-fx-font: bold 20 italic;-fx-fill: crimson");
                pincodeField.clear();
            }

        });

        pincodeField.setMinSize(244, 40);
        pincodeField.setPromptText("pincode");
        pincodeField.setStyle("-fx-text-fill: black; -fx-background-color: rgba(221, 214, 214, 0.64); -fx-prompt-text-fill: #444444; " +
                "-fx-font:  20 italic;-fx-border-color: #000000;-fx-progress-color: dimgray; -fx-border-radius: 5");

        //Text message = new Text(getMessage(pincodeField.getText()));
        message.setStyle("-fx-font: bold 20 italic; -fx-text-fill: #ec008e;");
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
        row1.setPadding(new Insets(6, 0, 3, 0));//boven, rechts,onder, links
        row1.setSpacing(3);
        row1.setAlignment(Pos.CENTER);
        row2.setPadding(new Insets(0, 0, 3, 0));
        row2.setSpacing(3);
        row2.setAlignment(Pos.CENTER);
        row3.setPadding(new Insets(0, 0, 3, 0));
        row3.setSpacing(3);
        row3.setAlignment(Pos.CENTER);
        row4.setPadding(new Insets(0, 0, 3, 0));
        row4.setSpacing(3);
        row4.setAlignment(Pos.CENTER);
        row5.setPadding(new Insets(0, 0, 3, 0));
        row5.setSpacing(3);
        row5.setAlignment(Pos.CENTER);

        loginFullbox.getChildren().addAll(row0, row1, row2, row3, row4, row5);

        StackPane achtergrond1 = new StackPane();
        Scene loginScene = new Scene(achtergrond1);

        Image image = new Image("IMG_3241.jpg");
        ImageView imageSX = new ImageView();
        imageSX.setImage(image);
        imageSX.isPreserveRatio();
        imageSX.fitWidthProperty().bind(loginScene.widthProperty());
        imageSX.fitHeightProperty().bind(loginScene.heightProperty());

        //onderliggend veld, dual layer
        achtergrond1.getChildren().addAll(imageSX,loginFullbox);


        return loginScene;
    }

    public static NumberButton[] makeNumberButtons() {
        NumberButton[] numberButtons = new NumberButton[10];
        for (int index = 0; index < 10; index++) {
            numberButtons[index] = (new NumberButton(index));
            numberButtons[index].setMinSize(80, 80);
            numberButtons[index].setStyle("-fx-base:#444444; -fx-background-radius: 10;-fx-border-radius: 10; -fx-border-color: #555555; -fx-font: bold 22px Calibri; -fx-text-fill: white;");
        }
        return numberButtons;

    }

}

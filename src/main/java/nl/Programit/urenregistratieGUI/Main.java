package nl.Programit.urenregistratieGUI;


import nl.Programit.urenregistratieGUI.FXComponents.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nl.Programit.urenregistratieModel1.AdminOperator;
import nl.Programit.urenregistratieModel1.Person;
import nl.Programit.urenregistratieModel1.Trainer;

public class Main extends Application {

    PasswordField pincodeField = new PasswordField();
    Text message = new Text();



    @Override
    public void start(Stage primaryStage) throws Exception{

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
        clearButton.setOnAction(event ->pincodeField.clear() );
        enterButton.setMinSize(80, 80);
        enterButton.setStyle("-fx-base:darkgreen; -fx-background-radius: 10; -fx-border-color: #ffffff; -fx-font: bold 18px Calibri; -fx-text-fill: yellow;");

        enterButton.setOnAction(event -> {
            int pincodenr = Integer.parseInt(pincodeField.getText());
                Person thisPerson = AdminOperator.getInstance().checkPin(pincodenr);
                 if ( (pincodeField.getLength()==4) && !(thisPerson==null) ) {
                     if ((thisPerson instanceof Trainer)) {
                         pincodeField.clear();
                         message.setText("U word door verwezen naar het volgende scherm");
                         message.setStyle("-fx-font: bold 18px Calibri; -fx-fill: green");

                     }

                    message.setText("U word door verwezen naar het volgende scherm");
                    message.setStyle("-fx-font: bold 18px Calibri; -fx-fill: green");
                }else {
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
            knop.setOnAction(e -> push(knop.getNumber()));
        }
        row0.getChildren().add(message);
        row1.getChildren().addAll(pincodeField);
        row2.getChildren().addAll(numberButtons[1], numberButtons[2], numberButtons[3]);
        row3.getChildren().addAll(numberButtons[4], numberButtons[5], numberButtons[6]);
        row4.getChildren().addAll(numberButtons[7], numberButtons[8], numberButtons[9]);
        row5.getChildren().addAll(clearButton, numberButtons[0],enterButton);

        row0.setAlignment(Pos.CENTER);
        row1.setPadding(new Insets(6,0,0,0));//boven, rechts,onder, links
        row1.setAlignment(Pos.CENTER);
        row2.setPadding(new Insets(6,0,0,0));
        row2.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        row4.setAlignment(Pos.CENTER);
        row5.setAlignment(Pos.CENTER);

        loginFullbox.getChildren().addAll(row0,row1,row2,row3,row4,row5);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ProgramIT - SX_Sport");
        primaryStage.setScene(new Scene(loginFullbox, 300, 275));
        primaryStage.show();
    }


    public NumberButton[] makeNumberButtons() {
        NumberButton[] numberButtons = new NumberButton[10];
        for (int index = 0; index < 10; index++) {
            numberButtons[index] = (new NumberButton(index));
            numberButtons[index].setMinSize(80, 80);
            numberButtons[index].setStyle("-fx-base:#444444; -fx-background-radius: 10; -fx-border-color: #ffffff; -fx-font: bold 22px Calibri; -fx-text-fill: yellow;");
        }return numberButtons;

    }


    public void push(int key) {

            pincodeField.setText(pincodeField.getText() + key);
        }


    public static void main(String[] args) {
        launch(args);
    }
}

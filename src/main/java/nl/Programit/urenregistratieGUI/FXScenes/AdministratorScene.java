package nl.Programit.urenregistratieGUI.FXScenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nl.Programit.urenregistratieGUI.FXComponents.*;
import nl.Programit.urenregistratieGUI.Main;
import nl.Programit.administratie.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class AdministratorScene {

    private static  Person thisPerson;
    private static int type = 0;
    private static VBox AccountVBox1;
    private static VBox AccountVBox2;
    private static VBox AccountVBox3;
    private static VBox AccountTopVBox;

    private static MyText alerttext = new MyText("", Color.CRIMSON);
    private static MenuButton menuButton = new MenuButton("Create Account of type");

    private static MyTextField idNr = new MyTextField("ID");
    private static MyTextField gender = new MyTextField("Geslacht");
    private static MyTextField firstName = new MyTextField("Voornaam");
    private static MyTextField lastName = new MyTextField("Achternaam");
    private static MyTextField street = new MyTextField("Straat");
    private static MyTextField houseNr = new MyTextField("Huisnummer");
    private static MyTextField zipCode = new MyTextField("Postcode");
    private static MyTextField city = new MyTextField("Stad");
    private static MyTextField email = new MyTextField("E-mail Adres");
    private static MyTextField bankAccount = new MyTextField("Bank Rekening");
    private static MyTextField pin = new MyTextField("Pincode");
    private static MyDatePicker birthdayDate = new MyDatePicker();

    public static Scene getAdministratorScene(Person person) {


        Administrator administrator = (Administrator) person;
        MyText welkomText = new MyText("Welkom Administrator: " + administrator.getFirstName());


        //menuButton and event to set PersonType

        MyButton customertoEditButton = new MyButton("Vind");
        MyTextField customerToEditField = new MyTextField("Account Pin");
        HBox editCustomer = new HBox(customerToEditField,customertoEditButton);
        editCustomer.setSpacing(10);
        editCustomer.setAlignment(Pos.CENTER);
        MenuItem klant = new MenuItem("Klant");
        MenuItem trainer = new MenuItem("Trainer");
        MenuItem admin = new MenuItem("Administrator");

        //menubutton en menuItems
        menuButton.getItems().addAll(klant, trainer, admin);
        menuButton.setStyle("-fx-font: 20 italic; -fx-base: #ec008e; ;-fx-background-radius: 7; -fx-border-radius: 7" );

        klant.setOnAction(e -> {
            type = 1;
            menuButton.setText("Klant");
        });
        trainer.setOnAction(e -> {
            type = 2;
            menuButton.setText("Trainer");
        });
        admin.setOnAction(e -> {
            type = 3;
            menuButton.setText("Administrator");
        });


        MyButton logout = Main.getLogout();

        MyButton createAccount = new MyButton("Create Account");
        MyButton editAccount = new MyButton("Edit Account");
        MyButton confirmB = new MyButton("Bevestig");
        confirmB.setStyle("-fx-font: 20 italic; -fx-base: #82BD02;-fx-background-radius: 7; -fx-border-radius: 7");
        MyButton update = new MyButton("Update");
        update.setStyle("-fx-font: 20 italic; -fx-base: #82BD02;-fx-background-radius: 7; -fx-border-radius: 7");
        MyButton delete = new MyButton("Delete Account");
        delete.setStyle("-fx-font: 20 italic; -fx-base: #ff0000;-fx-background-radius: 7; -fx-border-radius: 7");
        birthdayDate.setStyle("-fx-border-color: #5b5b5b;-fx-background-color: rgba(225, 225, 225, 0.90);-fx-font: 20 italic;" +
                "-fx-prompt-text-fill: #7b7b7b; -fx-text-fill: #000000;-fx-background-radius: 7; -fx-border-radius: 7");




        //ActionEvents various buttons
        createAccount.setOnAction(event1 -> {
            AccountTopVBox.getChildren().clear();
            AccountTopVBox.getChildren().add(menuButton);
            AccountVBox3.getChildren().clear();
            AccountVBox3.getChildren().addAll(confirmB,alerttext);
            confirmB.setText("Bevestig");
        });
        editAccount.setOnAction(event1 -> {
            AccountTopVBox.getChildren().clear();
            AccountTopVBox.getChildren().addAll(editCustomer,menuButton);
            AccountVBox3.getChildren().clear();
            AccountVBox3.getChildren().addAll(update,alerttext, delete);


        });

        customertoEditButton.setOnAction(event1 -> {
            int pinToCheck = Integer.parseInt(customerToEditField.getText());

            thisPerson = DataPersister.getInstance().retrieveEntry(pinToCheck);

                    if ((thisPerson instanceof Trainer)) {
                        idNr.setText(""+((Trainer)thisPerson).getEmployeeId());

                    } else if ((thisPerson instanceof Administrator)) {
                        idNr.setText(""+((Administrator)thisPerson).getAdministratorID());

                    } else if ((thisPerson instanceof Customer)) {
                        idNr.setText(""+((Customer)thisPerson).getCustumerID());

                    }

            gender.setText(thisPerson.getGender());
            firstName.setText(thisPerson.getFirstName());
            lastName.setText(thisPerson.getLastName());
            street.setText(thisPerson.getStreet());
            houseNr.setText(""+thisPerson.getHouseNr());
            zipCode.setText(thisPerson.getZipCode());
            city.setText(thisPerson.getCity());
            birthdayDate.setPromptText(""+thisPerson.getBirthDay());
            bankAccount.setText(thisPerson.getBankAccountID());
            email.setText(thisPerson.getEmailAddress());
            pin.setText(""+thisPerson.getPin());


        });

        update.setOnAction(event -> {
            int pinToCheck = Integer.parseInt(customerToEditField.getText());

            //Person thisPerson = DataPersister.getInstance().retrieveEntry(pinToCheck);/// check check

            if(menuButton.getText().equals("Create Account of type")) {
                alerttext.setText("Selecteer eerst juiste account type!");
            }
            else{
                DataPersister dPinstance = DataPersister.getInstance();
                thisPerson = getPType();

                thisPerson =setPersonReady(thisPerson);

                dPinstance.updateEntry(thisPerson, pinToCheck);

                clearFields();
            }});

        delete.setOnAction(event1 -> {
//            int pinToCheck = Integer.parseInt(customerToEditField.getText());
//
//            Person thisPerson = DataPersister.getInstance().retrieveEntry(pinToCheck);
            DataPersister dPinstance = DataPersister.getInstance();
            dPinstance.deleteEntry(thisPerson);

            clearFields();
        });


        confirmB.setOnAction(event -> {
//            int pinToCheck = Integer.parseInt(pin.getText());
//            Person thatPerson = DataPersister.getInstance().retrieveEntry(pinToCheck);
//            if (thatPerson.getPin()!=0){
//                alerttext.setText(alerttext.getText()+"Deze PinCode is reeds in gebruik");
//            }
//
//            else
            if(menuButton.getText().equals("Create Account of type")) {
              alerttext.setText(alerttext.getText()+"Selecteer eerst juiste account type!");
            }
            else{
            DataPersister dPinstance = DataPersister.getInstance();
            thisPerson = getPType();
                //All fields get filled
                setPersonReady(thisPerson);
                //writes person to DB
            dPinstance.createEntry(thisPerson);
                //dPinstance.getInstance().createEntry(thisPerson);

            //clear fields after person is added to database
           clearFields();


        }});


        //Boxes and elements
        VBox elements = new VBox(welkomText);

        //left side Vbox Basic Menu options
        VBox menuVBox = new VBox(10,logout, createAccount,editAccount);
        logout.setMinWidth(180);
        //logout.setStyle("-fx-text-alignment: center");
        logout.setAlignment(Pos.TOP_LEFT);
        createAccount.setAlignment(Pos.CENTER_RIGHT);

        //center VBox createAccount and Attributes
        AccountVBox1 = new VBox(15,idNr,gender, firstName,lastName,street,houseNr);
        AccountVBox2 = new VBox(15,zipCode,city,birthdayDate,bankAccount,email, pin);
        AccountVBox3 =new VBox(15,confirmB,alerttext);
        AccountVBox3.setAlignment(Pos.CENTER);
        AccountTopVBox = new VBox(15,menuButton);
        AccountTopVBox.setAlignment(Pos.CENTER);
        HBox AccountHBox = new HBox(AccountVBox1,AccountVBox2);
        AccountHBox.setAlignment(Pos.CENTER);
        AccountHBox.setSpacing(30);
        VBox fullAccount = new VBox(15,AccountTopVBox,AccountHBox,AccountVBox3);
        //fullAccount.setStyle("-fx-background-color: aliceblue");

        StackPane achtergrond2 = new StackPane();
        Scene scene = new Scene(achtergrond2);

        Image image = new Image("IMG_3242.jpg");
        ImageView imageSX = new ImageView();
        imageSX.setImage(image);
        imageSX.isPreserveRatio();
        imageSX.fitWidthProperty().bind(scene.widthProperty());
        imageSX.fitHeightProperty().bind(scene.heightProperty());

        //onderliggend veld, dual layer


        // bring all elements together :)
        VBox fullbox = new VBox(menuVBox, fullAccount);
        menuVBox.setAlignment(Pos.TOP_LEFT);
        fullAccount.setAlignment(Pos.CENTER);
        achtergrond2.getChildren().addAll(imageSX,fullbox);

        return scene;
    }

    private static void clearFields() {
        //clear fields after person is added to database
        idNr.clear();gender.clear();firstName.clear();lastName.clear();street.clear();houseNr.clear();zipCode.clear();birthdayDate.setValue(null);birthdayDate.setPromptText("");
        city.clear();bankAccount.clear();email.clear(); pin.clear();
        alerttext.setText("");
        //birthdayDate.
        menuButton.setText("Create Account of type");
    }

    private static Person setPersonReady(Person thisPerson) {

        if(thisPerson instanceof Administrator){
            ((Administrator)thisPerson).setAdministratorID(Integer.parseInt(idNr.getText()));

        }else if(thisPerson instanceof Trainer){
            ((Trainer)thisPerson).setEmployeeId(Integer.parseInt(idNr.getText()));
        }else if(thisPerson instanceof Customer){
            ((Customer)thisPerson).setCustumerID(Integer.parseInt(idNr.getText()));
        }
        thisPerson.setFirstName(firstName.getText());
        thisPerson.setLastName(lastName.getText());
        thisPerson.setStreet(street.getText());
        thisPerson.setHouseNr(Integer.parseInt(houseNr.getText()));
        thisPerson.setCity(city.getText());
        thisPerson.setZipCode(zipCode.getText());
        thisPerson.setBirthDay(birthdayDate.getValue());
        thisPerson.setPin(Integer.parseInt(pin.getText()));
        thisPerson.setBankAccountID(bankAccount.getText());
        thisPerson.setEmailAddress(email.getText());
        thisPerson.setGender(gender.getText());
        return thisPerson;
    }


    private static Person getPType() {
        if (type == 1)
            return new Customer();
        else if (type == 2)
            return new Trainer();
        else if (type == 3)
            return new Administrator();
        else return null;
    }

    private static Person getEditablePerson(int pin){
        DataPersister dPinstance = DataPersister.getInstance();
        thisPerson = getPType();
        return thisPerson;
    }

}

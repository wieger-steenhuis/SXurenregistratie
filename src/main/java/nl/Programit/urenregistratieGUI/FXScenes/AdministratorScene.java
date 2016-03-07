package nl.Programit.urenregistratieGUI.FXScenes;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nl.Programit.urenregistratieGUI.FXComponents.*;
import nl.Programit.urenregistratieGUI.Main;
import nl.Programit.administratie.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class AdministratorScene {

    private static int type = 0;
    private static VBox createAccountVBox;

    public static Scene getAdministratorScene(Person person) {


        Administrator administrator = (Administrator) person;
        MyText welkomText = new MyText("Welkom Administrator: " + administrator.getFirstName());


        //menuButton and event to set PersonType
        MenuButton menuButton = new MenuButton("Create Account of type");
        MenuItem klant = new MenuItem("Klant");
        MenuItem trainer = new MenuItem("Trainer");
        MenuItem admin = new MenuItem("Administrator");

        menuButton.getItems().addAll(klant, trainer, admin);

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
        MyButton confirmB = new MyButton("Bevestig");
        MyText alerttext = new MyText("", Color.CRIMSON);

        MyTextField idNr = new MyTextField("ID");
        MyTextField gender = new MyTextField("Geslacht");
        MyTextField firstName = new MyTextField("Voornaam");
        MyTextField lastName = new MyTextField("Achternaam");
        MyTextField street = new MyTextField("Straat");
        MyTextField houseNr = new MyTextField("Huisnummer");
        MyTextField zipCode = new MyTextField("Postcode");
        MyTextField city = new MyTextField("Stad");
        MyTextField email = new MyTextField("E-mail Adres");
        MyTextField bankAccount = new MyTextField("Bank Rekening");
        MyTextField pin = new MyTextField("Pincode");
        MyDatePicker birthdayDate = new MyDatePicker();


        //ActionEvents various buttons
        confirmB.setOnAction(event -> {
            if(menuButton.getText().equals("Create Account of type")) {
              alerttext.setText("Selecteer eerst juiste account type!");
            }
            else{
            DataPersister dPinstance = DataPersister.getInstance();
            Person thisPerson = getPType();

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


            dPinstance.createEntry(thisPerson);
            dPinstance.getInstance().createEntry(thisPerson);

            //clear fields after person is added to database
           idNr.clear();gender.clear();firstName.clear();lastName.clear();street.clear();houseNr.clear();zipCode.clear();birthdayDate.setValue(null);
                        city.clear();bankAccount.clear();email.clear(); pin.clear();
                alerttext.setText("");
                //birthdayDate.
            menuButton.setText("Create Account of type");


        }});


        //Boxes and elements
        VBox elements = new VBox(welkomText);

        //left side Vbox Basic Menu options
        VBox menuVBox = new VBox(elements, logout, createAccount);
        logout.setAlignment(Pos.TOP_LEFT);
        createAccount.setAlignment(Pos.CENTER_RIGHT);

        //center VBox createAccount and Attributes
        createAccountVBox = new VBox(menuButton, idNr,gender, firstName,lastName,street,houseNr,zipCode,
                city,birthdayDate,bankAccount,email, pin,confirmB,alerttext);
        createAccountVBox.setSpacing(15);
        createAccountVBox.setAlignment(Pos.CENTER);

        // bring all elements together :)
        HBox fullbox = new HBox(menuVBox, createAccountVBox);
        Scene scene = new Scene(fullbox);
        return scene;
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


}

package nl.Programit.urenregistratieGUI.FXScenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import nl.Programit.urenregistratieGUI.FXComponents.*;
import nl.Programit.urenregistratieGUI.Main;
import nl.Programit.urenregistratieModel1.*;

/**
 * Created by udr013 on 3-3-2016.
 */
public class AdministratorScene {

    private static int type = 0;

    public static Scene getAdministratorScene(Person person) {



        Administrator administrator= (Administrator)person;
        MyText welkomText = new MyText("Welkom Administrator: " +administrator.getFirstName());


        //menuButton and event to set PersonType
        MenuButton menuButton =new MenuButton("Create Account of type");
        MenuItem klant = new MenuItem("klant");
        MenuItem trainer = new MenuItem("Trainer");
        MenuItem admin = new MenuItem("Administrator");

        menuButton.getItems().addAll(klant, trainer, admin);

        klant.setOnAction(e -> type = 1);
        trainer.setOnAction(e -> type =2);
        admin.setOnAction(e -> type = 3);


        MyButton logout = Main.getLogout();

        MyButton createAccount = new MyButton("Create Account");
        MyButton confirmB = new MyButton("Bevestig");

        MyTextField idNr = new MyTextField("ID");
        MyTextField firstName = new MyTextField("First Name");
        MyTextField pin = new MyTextField("pincode");
        //MyDatePicker birthdayDate = new MyDatePicker();


        //ActionEvents various buttons
        confirmB.setOnAction(event -> {
            DataPersister dPinstance = DataPersister.getInstance();
            Person thisPerson = getPType();

            thisPerson.setPin(Integer.parseInt(pin.getText()));
            thisPerson.setFirstName(firstName.getText());
            //thisPerson.setAdministratorID(Integer.parseInt(idNr.getText()));

            dPinstance.createEntry(thisPerson);
            dPinstance.getInstance().createEntry(thisPerson);

            //clear fields after person is added to database
            idNr.clear();
            firstName.clear();
            pin.clear();


        });




        //Boxes and elements
        VBox elements = new VBox(welkomText);

        //left side Vbox Basic Menu options
        VBox menuVBox = new VBox(elements,logout,createAccount);
        logout.setAlignment(Pos.TOP_LEFT);
        createAccount.setAlignment(Pos.CENTER_RIGHT);

        //center VBox createAccount and Attributes
        VBox createAccountVBox = new VBox(menuButton,idNr, firstName, pin, confirmB);
        createAccountVBox.setSpacing(15);
        //createAccountVBox.setPadding(new Insets(20,20,20,20));
        createAccountVBox.setAlignment(Pos.CENTER);

        // bring all elements together :)
        HBox fullbox = new HBox(menuVBox,createAccountVBox );
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

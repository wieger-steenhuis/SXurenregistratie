package nl.programit.sxurenadministratie.gui.fxscenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import nl.programit.administratie.Customer;
import nl.programit.administratie.Person;
import nl.programit.sxurenadministratie.gui.Main;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyButton;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyRadioButton;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyText;

import java.util.ArrayList;

/**
 * Created by udr013 on 3-3-2016.
 */
public class CustomerScene {

    public static Scene getCustomerScene(Person person) {

        Customer customer = (Customer) person;

        MyText welkomText = new MyText("Welkom " + customer.getFirstName() + " " + customer.getLastName() +
                ", hier vind u uw sessies");
        HBox welkom = new HBox(welkomText);
        welkom.setAlignment(Pos.CENTER);

        MyButton logout = Main.getLogout();
        VBox menuVBox = new VBox(30, logout);
        menuVBox.setPadding(new Insets(5, 30, 100, 5));

        //centre Vbox for "sessie"  with it's components
        VBox customerSessionBox = new VBox(30);
        customerSessionBox.setAlignment(Pos.CENTER);
        customerSessionBox.getChildren().add(welkomText);
        ToggleGroup sessions = new ToggleGroup();
        ArrayList<MyRadioButton> customerCheckboxes = new ArrayList<>();

        for (int x = 1; x < 13; x++) {
            MyRadioButton y = new MyRadioButton(" Sessie "+x);

            y.setToggleGroup(sessions);
            customerCheckboxes.add(y);
            customerSessionBox.getChildren().add(y);
            y.setAlignment(Pos.CENTER);
        }

        customerSessionBox.setPadding(new Insets(30, 30, 30, 30));
        customerSessionBox.setStyle("-fx-background-color: rgba(221, 214, 214, 0.90);-fx-font: 20 italic;" +
                "-fx-background-radius: 7; -fx-border-radius: 7");



        VBox fullbox = new VBox(menuVBox, customerSessionBox);
        //fullbox.setFillHeight(true);


        Image image = new Image("IMG_3242.jpg");
        ImageView imageSX = new ImageView();
        StackPane achtergrond2 = new StackPane(imageSX, fullbox);
        Scene scene = new Scene(achtergrond2);
        imageSX.setImage(image);
        imageSX.isPreserveRatio();
        imageSX.fitWidthProperty().bind(scene.widthProperty());
        imageSX.fitHeightProperty().bind(scene.heightProperty());

        return scene;
    }

}

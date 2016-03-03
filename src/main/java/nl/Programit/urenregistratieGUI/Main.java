package nl.Programit.urenregistratieGUI;


import javafx.application.Application;
import javafx.stage.Stage;
import nl.Programit.urenregistratieGUI.FXComponents.LoginScene;

public class Main extends Application {


    Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {


        //primaryStage = window;

        window.setTitle("ProgramIT - SX_Sport");

        window.setScene(LoginScene.getLoginScene(window));
        window.setMaximized(true);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

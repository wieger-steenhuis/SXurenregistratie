package nl.Programit.urenregistratieGUI;


import javafx.application.Application;
import javafx.stage.Stage;
import nl.Programit.urenregistratieGUI.FXComponents.LoginScene;

public class Main extends Application {


    Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage = window;
        
        primaryStage.setTitle("ProgramIT - SX_Sport");

        primaryStage.setScene(LoginScene.getLoginScene(window));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

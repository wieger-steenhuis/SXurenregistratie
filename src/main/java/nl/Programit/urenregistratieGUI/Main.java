package nl.Programit.urenregistratieGUI;


import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nl.Programit.urenregistratieGUI.FXComponents.MyButton;
import nl.Programit.urenregistratieGUI.FXScenes.LoginScene;

public class Main extends Application {


    private static Stage window = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {


        //primaryStage = window;

        window.setTitle("ProgramIT - SX_Sport");
        window.setScene(LoginScene.getLoginScene(window));
        window.setMaximized(true);
        window.show();
    }

    public static final MyButton getLogout(){
        MyButton logout = new MyButton("logout");
        logout.setOnAction(event ->
            window.setScene(LoginScene.getLoginScene(window)));
        return logout;
    }




    public static void main(String[] args) {
        launch(args);
    }

}

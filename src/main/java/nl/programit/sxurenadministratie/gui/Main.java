package nl.programit.sxurenadministratie.gui;


import javafx.application.*;
import javafx.stage.*;
import nl.programit.sxurenadministratie.gui.fxcomponents.MyButton;
import nl.programit.sxurenadministratie.gui.fxscenes.LoginScene;


public class Main extends Application {


    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;

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

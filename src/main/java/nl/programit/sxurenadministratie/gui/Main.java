package nl.programit.sxurenadministratie.gui;


import javafx.application.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import nl.programit.sxurenadministratie.gui.fxcomponents.*;
import nl.programit.sxurenadministratie.gui.fxscenes.*;


public class Main extends Application {


    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;

        window.setTitle("ProgramIT - SX_Sport");
        window.getIcons().add(new Image("logoSX.png")); //logo SX Sports als pictogram in de taakbalk en linksboven in 'window'
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

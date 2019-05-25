package ExaME_Package;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class StartingPoint_Main extends Application {



    public static User globalUser;
   public static Scene globalScene = null;
   public static Stage globalPrimaryStage = null;

    public static void changeScene(String sceneTitle, Scene getScene)
    {
        StartingPoint_Main.globalPrimaryStage.setScene(getScene);
        StartingPoint_Main.globalPrimaryStage.setTitle(sceneTitle);
    }



    public static void main(String[] args)

    {

        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {


        globalScene = new Login().getLoginScene();
        primaryStage.setScene(globalScene);
        globalScene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());
        primaryStage.setTitle("Login");

        primaryStage.show();
        globalPrimaryStage = primaryStage;

    }
}

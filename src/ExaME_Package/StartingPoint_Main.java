package ExaME_Package;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class StartingPoint_Main extends Application {


   public static Scene globalScene = null;
   public static Stage globalPrimaryStage = null;

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




        TimeUnit.SECONDS.sleep(3);
        String toastMsg = "Error, error !!!111!!!";
        int toastMsgTime = 3500; //3.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime= 500; //0.5 seconds
        Toast.makeText(globalPrimaryStage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

    }
}

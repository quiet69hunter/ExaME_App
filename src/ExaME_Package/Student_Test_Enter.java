package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


/*
Plik z GUI  wejscia do danego testu
UPDATES

26.05.2019 - Kopera - utworzenie klasy


LIST OF THING TO IMPROVE/ADD


 */

public class Student_Test_Enter extends Application {

    public Scene getStudentTestEnter()
    {

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("TEST CHOOSE");
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element

        Label accessKey_L= new Label("ACCESS KEY");
        grid.add(accessKey_L,0,1);

        TextField accessKey_T = new TextField();
        grid.add(accessKey_T,1,1);



        //  BUTTON

        Button button = new Button();
        button.setText("Go to the test");



        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {


            }
        });
        grid.add(button, 1, 3);


        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(SolvingTheTest.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Student_Test_Enter().getStudentTestEnter();
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

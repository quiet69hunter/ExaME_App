package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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


                if(!accessKey_T.getText().isEmpty())
                {
                    DataBaseManager dataBaseManager = null;
                    try {
                        dataBaseManager = new DataBaseManager();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String  sql = "SELECT test.id FROM test WHERE test.accessKey='"+accessKey_T.getText()+"';";
                    dataBaseManager.sendQuery_GET(sql);
                    String id=dataBaseManager.resultList.get(0).get("id").toString();



                    Timer timer = new Timer();
                    sql = "SELECT test.timeLimit FROM test WHERE test.accessKey='"+accessKey_T.getText()+"';";
                    dataBaseManager.sendQuery_GET(sql);
                    timer.TIME = Integer.parseInt(dataBaseManager.resultList.get(0).get("timeLimit").toString());


                    // wywolanie okienka timera
                    try {
                        ((Student)(StartingPoint_Main.globalUser)).timerScene = timer.getTimer();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    ((Student)(StartingPoint_Main.globalUser)).timerStage = new Stage();
                    ((Student)(StartingPoint_Main.globalUser)).timerStage.setScene(((Student)(StartingPoint_Main.globalUser)).timerScene);

                    ((Student)(StartingPoint_Main.globalUser)).timerScene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());
                    ((Student)(StartingPoint_Main.globalUser)).timerStage.setTitle("TIMER");
                    ((Student)(StartingPoint_Main.globalUser)).timerStage.setX((5));
                    ((Student)(StartingPoint_Main.globalUser)).timerStage.setY((5));
                   // ((Student)(StartingPoint_Main.globalUser)).timerStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
                   // ((Student)(StartingPoint_Main.globalUser)).timerStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);

                    ((Student)(StartingPoint_Main.globalUser)).timerStage.show();



                    Date dt = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    ((Student)(StartingPoint_Main.globalUser)).startDate =  sdf.format(dt);
                    System.out.println(((Student)(StartingPoint_Main.globalUser)).startDate);


                    ((Student)(StartingPoint_Main.globalUser)).idTest = id;
                    try {
                        StartingPoint_Main.changeScene("TEST", new SolvingTheTest().getSolvingTheTest());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                accessKey_T.setText("");

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

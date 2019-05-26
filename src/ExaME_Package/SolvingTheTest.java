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
Plik z GUI dla rozwiązywania testu
UPDATES

26.05.2019 -Kopera - utworzenie klasy


LIST OF THING TO IMPROVE/ADD


 */

public class SolvingTheTest extends Application{


    public Scene getSolvingTheTest()
    {

        GridPane grid = new GridPane();
        grid.setId("grid");



        Text scenetitle = new Text("TEST TITLE");
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label questionContent_T= new Label("TRESC PYTANIA");
        grid.add(questionContent_T,0,1);


        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("ODPOWIEDZ A");
        rb1.setToggleGroup(group);
        grid.add(rb1, 0, 2);

        RadioButton rb2 = new RadioButton("ODPOWIEDZ B");
        rb2.setToggleGroup(group);
        grid.add(rb2, 0, 3);

        RadioButton rb3 = new RadioButton("ODPOWIEDZ C");
        rb3.setToggleGroup(group);
        grid.add(rb3, 0, 4);

        RadioButton rb4 = new RadioButton("ODPOWIEDZ D");
        rb4.setToggleGroup(group);
        grid.add(rb4, 0, 5);




        //  BUTTON

        Button button = new Button();
        button.setText("Next question");


        DataBaseManager dataBaseManager = null;
        try {
            dataBaseManager = new DataBaseManager();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String idtestu1=((Student)(StartingPoint_Main.globalUser)).idTest;
        String sql="SELECT questionContent FROM question WHERE idTest = '"+idtestu1+"';";
        dataBaseManager.sendQuery_GET(sql);
        String  content=dataBaseManager.resultList/*get(0)*/.toString();
        System.out.println("Pytanie " + content);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

               /* if(((Student)(StartingPoint_Main.globalUser)).idTest < ((Lecturer)(StartingPoint_Main.globalUser)).numOfQuestionsInTest)
                {
                    ((Lecturer)(StartingPoint_Main.globalUser)).questionCounter++;
                    Toast.makeToast("THE QUESTION WAS SUCCESSFULLY ADDED TO THE DATABASE");
                }
                else
                {
                    ((Lecturer)(StartingPoint_Main.globalUser)).questionCounter = 1;
                    ((Lecturer)(StartingPoint_Main.globalUser)).numOfQuestionsInTest = 0;
                    ((Lecturer)(StartingPoint_Main.globalUser)).newTestID = "";

                    Toast.makeToast("YOU ADDED TOTAL AMOUNT OF QUESTIONS TO THIS TEST. \n THE TEST WAS SUCCESSFULLY ADDED TO THE DATABASE");

                    StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
                }*/
            }
        });
        grid.add(button, 1, 7);


        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(SolvingTheTest.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new SolvingTheTest().getSolvingTheTest();
        primaryStage.setScene(scene);
        primaryStage.setTitle("TEST");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

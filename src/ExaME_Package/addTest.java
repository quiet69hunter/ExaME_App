package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


/*
Plik ze GUI dla dodawania testu


UPDATES
23.05.2019 - Kopera - stworzenie klasy
25.05.2019 - Kopera - tworzenie testu


LIST OF THING TO IMPROVE/ADD



 */

public class addTest extends Application {


    public Scene getAddTest() {

        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("CREATE TEST"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);


        Label title_L = new Label("TITLE:");
        grid.add(title_L, 0, 2);

        TextField title_T = new TextField();
        grid.add(title_T, 1, 2);

        Label subject_L = new Label("NAME OF SUBJECT:");
        grid.add(subject_L, 0, 3);

        TextField subject_T = new TextField();
        grid.add(subject_T, 1, 3);

        Label questionAmount_L = new Label("NUMBER OF QUESTIONS:");
        grid.add(questionAmount_L, 0, 4);

        TextField questionAmount_T = new TextField();
        grid.add(questionAmount_T, 1, 4);

        Label time_L = new Label("TIME LIMIT:");
        grid.add(time_L, 0, 5);

        TextField time_T = new TextField();
        grid.add(time_T, 1, 5);


        //  BUTTON

        Button button = new Button();
        button.setText("CREATE TEST");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String questionAmount_S = questionAmount_T.getText();
                String title_S = title_T.getText();
                String time_S = time_T.getText();
                String subject_S = subject_T.getText();
                Integer questionAmount_I=0;


                Integer time_I =null;
                time_I.parseInt(time_S);



                if(!questionAmount_T.getText().toString().isEmpty())
               {

                    questionAmount_I = Integer.valueOf(questionAmount_S);
                  // System.out.println(questionAmount_I);

                   if(questionAmount_I<=0)
                   {
                       Toast.makeToast("QUESTION AMOUNT CANNOT BE ZERO OR LESS");
                       //zla ilosc pytan
                   }
                   else
                   {


                       Test t = new Test(title_S,subject_S,questionAmount_I,time_I);
                       //id wykladowcy jakos pobrac trzeba!!!
                       String sql = "INSERT INTO `test`( `testTitle`,`testQuestionsAmount`, `timeLimit`, `accessKey`, `subject`, `idLecturer`) VALUES ('" + title_T.getText() + "','" + questionAmount_T.getText() + "', '" + time_T.getText() + "','"+t.getKey()+"','" + subject_T.getText() + "',1);";

                       DataBaseManager dataBaseManager = null;
                       try {
                           dataBaseManager = new DataBaseManager();
                       } catch (ClassNotFoundException e) {
                           e.printStackTrace();
                       }
                       dataBaseManager.sendQuery_SET(sql);


                       //wywołać add Question
                   }
               }




                questionAmount_T.setText("");
                title_T.setText("");
                time_T.setText("");
                subject_T.setText("");
            }
        });


        grid.add(button, 1, 9);


        javafx.scene.Scene scene = new Scene(grid, 1600, 900);

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new addTest().getAddTest();
        primaryStage.setScene(scene);
        scene.getStylesheets().add(addTest.class.getResource("Style.css").toExternalForm());
        primaryStage.setTitle("ADD QUESTION");
        primaryStage.show();

    }


   /* public static void main(String[] args) {
        launch(args);
    }*/
}


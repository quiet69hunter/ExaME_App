package ExaME_Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addQuestion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("addQuestion");


        //  GRID

        var grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);         //  Horizontal gap
        grid.setVgap(20);          //  Vertical gap

        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("CREATE QUESTION"); //   Tekst
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element


        Label questionContent_L = new Label("ADD QUESTION CONTENT:");
        grid.add(questionContent_L, 0, 1);

        TextField questionContent_T = new TextField();
        grid.add(questionContent_T, 1, 1);



        Label answerA_L = new Label("ANSWER A:");
        grid.add(answerA_L, 0, 2);

        TextField answerA_T = new TextField();
        grid.add(answerA_T, 1, 2);



        Label answerB_L = new Label("ANSWER B:");
        grid.add(answerB_L, 0, 3);

        TextField answerB_T = new TextField();
        grid.add(answerB_T, 1, 3);



        Label answerC_L = new Label("ANSWER C:");
        grid.add(answerC_L, 0, 4);

        TextField answerC_T = new TextField();
        grid.add(answerC_T, 1, 4);



        Label answerD_L = new Label("ANSWER D:");
        grid.add(answerD_L, 0, 5);

        TextField answerD_T = new TextField();
        grid.add(answerD_T, 1, 5);




        Label correctAnswer_L = new Label("POINTS FOR CORRECT ANSWER:");
        grid.add(correctAnswer_L, 0, 6);

        TextField correctAnswer_T = new TextField();
        grid.add(correctAnswer_T, 1, 6);


        Label wrongAnswer_L = new Label("POINTS FOR WRONG ANSWER:");
        grid.add(wrongAnswer_L, 0, 7);

        TextField wrongAnswer_T = new TextField();
        grid.add(wrongAnswer_T, 1, 7);


        Label indexOFCorrectAnswer_L = new Label("CORRECT ANSWER IS:");
        grid.add(indexOFCorrectAnswer_L, 0, 8);

        TextField indexOFCorrectAnswer_T = new TextField();
        grid.add(indexOFCorrectAnswer_T, 1, 8);







        primaryStage.setScene(new Scene(grid, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

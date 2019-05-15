package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;






/*
Plik ze GUI menu studenta ( Student Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI



LIST OF THING TO IMPROVE/ADD

* dodac linki otwierające nowe okna, po nacisnięciu danego przycisku
* DESIGN - COLORS, FONTS


 */


public class Student_Menu extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("STUDENT MENU");


        //  GRID

        var grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);         //  Horizontal gap
        grid.setVgap(20);          //  Vertical gap

        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Button button_StartTest = new Button();
        button_StartTest.setText("START TEST");
        button_StartTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });
        grid.add(button_StartTest, 0, 1);
        //  END BUTTON



        Button button_CheckPreviousTestsScores = new Button();
        button_CheckPreviousTestsScores.setText("CHECK YOUR SCORE");
        button_CheckPreviousTestsScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });
        grid.add( button_CheckPreviousTestsScores, 0, 2);
        //  END BUTTON



        Button button_Logout = new Button();
        button_Logout.setText("LOGOUT");
        button_Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });
        grid.add(button_Logout, 0, 3);
        //  END BUTTON



        primaryStage.setScene(new Scene(grid, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

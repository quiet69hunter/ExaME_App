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

import java.io.IOException;
import java.sql.SQLException;






/*
Plik ze GUI menu studenta ( Student Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI
18.05.2019 - Kopera - zrobienie wstepnego interfejsu



LIST OF THING TO IMPROVE/ADD

* dodac linki otwierające nowe okna, po nacisnięciu danego przycisku
* DESIGN - COLORS, FONTS


 */


public class Student_Menu extends Application {


    public Scene getStudent_Menu() {

        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Button button_StartTest = new Button();
        button_StartTest.setText("START TEST");
        button_StartTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                StartingPoint_Main.changeScene("TEST", new Student_Test_Enter().getStudentTestEnter());
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
                try {
                    StartingPoint_Main.changeScene("SCORES", new Student_View_Scores().getStudent_View_Scores());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                StartingPoint_Main.globalUser = null;
                try {
                    StartingPoint_Main.changeScene("LOGIN", new Login().getLoginScene());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        grid.add(button_Logout, 0, 3);
        //  END BUTTON



        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("STUDENT MENU");



        primaryStage.setScene(getStudent_Menu());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

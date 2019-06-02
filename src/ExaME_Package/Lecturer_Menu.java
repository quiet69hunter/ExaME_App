package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


public class Lecturer_Menu extends Application {



    public Scene getLecturerMenu()
    {
        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Button button_MakeNewTest = new Button();
        button_MakeNewTest.setText("MAKE NEW TEST");
        button_MakeNewTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                StartingPoint_Main.changeScene("MAKE NEW TEST", new Lecturer_Make_New_Test().getLecturerMAekeNewTest());
            }
        });
        grid.add(button_MakeNewTest, 0, 1);
        //  END BUTTON



        Button button_generateKey = new Button();
        button_generateKey.setText("GENERATE NEW KEY FOR A TEST");
        button_generateKey.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    StartingPoint_Main.changeScene("Change Key", new Lecturer_ChangeKey().getLecturer_ChangeKey());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        grid.add( button_generateKey, 0, 2);
        //  END BUTTON


        Button button_viewTestIDS = new Button();
        button_viewTestIDS.setText("VIEW TESTS IDS");
        button_viewTestIDS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    StartingPoint_Main.changeScene("VIEW TEST IDS", new Lecturer_ViewTestIDs().getLecturer_ViewTestIDs());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        grid.add( button_viewTestIDS, 0, 3);
        //  END BUTTON

        Button button_viewTestResults = new Button();
        button_viewTestResults.setText("VIEW TESTS RESULTS");
        button_viewTestResults.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    StartingPoint_Main.changeScene("VIEW TEST RESULTS", new Lecturer_InputID_TestToView().getLecturer_InputID_TestToView());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        grid.add(  button_viewTestResults, 0, 4);
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
        grid.add(button_Logout, 0, 5);
        //  END BUTTON


        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("LECTURER MENU");


        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

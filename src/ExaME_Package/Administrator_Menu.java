package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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


public class Administrator_Menu extends Application {


    public Scene getAdministratorMenu()
    {
        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Button button_NewAccount = new Button();
        button_NewAccount.setText("CREATE NEW ACCOUNT");
        button_NewAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("ADD NEW USER TO DATABASE", new addNewUserToDatabase().getAddNewUserToDatabase());
            }
        });
        grid.add(button_NewAccount, 0, 1);
        //  END BUTTON



        Button button_ListOfUsers = new Button();
        button_ListOfUsers.setText("LIST OF USERS");
        button_ListOfUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    StartingPoint_Main.changeScene("LIST OF USERS", new Administrator_ListOfUsers().getAdministrator_ListOfUsers());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        grid.add( button_ListOfUsers, 0, 2);
        //  END BUTTON

        Button button_Delete = new Button();
        button_Delete.setText("DELETE ACCOUNT");
        button_Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("DELETE ACCOUNT", new Administrator_DeleteAccount().getAdministratorMenu());
            }
        });
        grid.add( button_Delete, 0, 3);
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
        grid.add(button_Logout, 0, 4);
        //  END BUTTON


        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }




    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("ADMINISTRATOR MENU");



        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

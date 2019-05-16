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






/*
Plik ze GUI menu studenta ( Student Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI



LIST OF THING TO IMPROVE/ADD

* dodac linki otwierające nowe okna, po nacisnięciu danego przycisku
* DESIGN - COLORS, FONTS


 */


public class Administrator_Menu extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("ADMINISTRATOR MENU");


        //  GRID

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);         //  Horizontal gap
        grid.setVgap(20);          //  Vertical gap

        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Button button_NewAccount = new Button();
        button_NewAccount.setText("CREATE NEW ACCOUNT");
        button_NewAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });
        grid.add(button_NewAccount, 0, 1);
        //  END BUTTON



        Button button_ChangeAccountType = new Button();
        button_ChangeAccountType.setText("CHANGE ACCOUNT TYPE");
        button_ChangeAccountType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });
        grid.add( button_ChangeAccountType, 0, 2);
        //  END BUTTON

        Button button_Delete = new Button();
        button_Delete.setText("DELETE ACCOUNT");
        button_Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

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

            }
        });
        grid.add(button_Logout, 0, 4);
        //  END BUTTON



        primaryStage.setScene(new Scene(grid, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






/*
Plik ze GUI dla logowania ( USER Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI
18.05.2019 - Kopera - zrobienie wstepnego interfejsu



LIST OF THING TO IMPROVE/ADD

* ustawic limit znaków jaki można wpisać do okienka na takie jak to zostało określone w wymaganiach funkcjonalnych
* wyswietlanie komunikatu, że email lub nick jest jest nieprawidlowy
* cialo funkcji validateData();
* DESIGN - COLORS, FONTS


 */


public class Login extends Application {



    //  validateData() sprawdza czy podany zestaw danych jest zgodny z tym
    //  co jest w bazie danych.
    // Jesli takie element istenieje - zwraca true
    //  jeśli nie - zwraca false

    public Boolean validateData(String email, String password)
    {
        if(true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }




    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("LOG INTO YOUR ACCOUNT");


        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        /*
        //Stworzyc pasek boczny w kolumnie 0
        Text navContainer = new Text("text");
        grid.add(navContainer, 0,0);
        navContainer.setId("navContainer");*/

        Text scenetitle = new Text("LOGIN"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 1, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element



        Label email_L = new Label("EMAIL:");
        grid.add(email_L, 1, 1);

        TextField email_T = new TextField();
        grid.add(email_T, 2, 1);
        email_T.setId("email_T");



        Label password_L = new Label("PASSWORD:");
        grid.add(password_L, 1, 2);

        PasswordField password_T = new PasswordField();
        grid.add(password_T, 2, 2);
        password_T.setId("password_T");






        //  BUTTON

        Button button = new Button();
        button.setText("LOGIN");



        //  Ustawiam co ma sie dziac po nacisnieciu przycisku
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                //  Wykonuje operacje jeżeli podany email jest prawidłowy

                if(validateData(email_T.getText(),password_T.getText()))
                {

                    System.out.println("Udalo sie zalogowac!");




                    email_T.setText("");
                    password_T.setText("");

                }
                else
                {
                    System.out.println("Podano nie poprawne dane! :-(");
                }












            }
        });
        grid.add(button, 2, 3);     //  dodaje przycisk do widoku


        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

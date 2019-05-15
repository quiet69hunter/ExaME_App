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

        var grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);         //  Horizontal gap
        grid.setVgap(20);          //  Vertical gap

        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("LOGIN"); //   Tekst
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element





        Label email_L = new Label("EMAIL:");
        grid.add(email_L, 0, 1);

        TextField email_T = new TextField();
        grid.add(email_T, 1, 1);



        Label password_L = new Label("PASSWORD:");
        grid.add(password_L, 0, 2);

        PasswordField password_T = new PasswordField();
        grid.add(password_T, 1, 2);






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
        grid.add(button, 1, 3);     //  dodaje przycisk do widoku


        //  END BUTTON





        primaryStage.setScene(new Scene(grid, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

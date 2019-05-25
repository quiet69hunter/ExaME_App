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

import java.sql.SQLException;
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


    public Scene scene = null;

    //  validateData() sprawdza czy podany zestaw danych jest zgodny z tym
    //  co jest w bazie danych.
    // Jesli takie element istenieje - zwraca true
    //  jeśli nie - zwraca false

    public Boolean validateData(String email, String password) throws ClassNotFoundException, SQLException {


        String sql = "SELECT EXISTS(SELECT *FROM user WHERE email = '" + email + "' AND password = '" + password + "');";
        DataBaseManager dataBaseManager = new DataBaseManager();
        Boolean userExistsInDatabase = dataBaseManager.sendQuery_GET_BOOLEAN(sql);

      return userExistsInDatabase;

    }




    public Scene getLoginScene() throws SQLException
    {



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

                try {
                    if(validateData(email_T.getText(),password_T.getText()))
                    {

                        Toast.makeToast("YOU LOGGED IN");


                        DataBaseManager dataBaseManager = new DataBaseManager();
                        String sql = "SELECT *FROM user WHERE user.email='" + email_T.getText() + "';";
                        dataBaseManager.sendQuery_GET(sql);
                        dataBaseManager.printResultList();




                        String accountType = (String)dataBaseManager.resultList.get(0).get("access");

                        String name = (String)dataBaseManager.resultList.get(0).get("name");
                        String surname = (String)dataBaseManager.resultList.get(0).get("surname");
                        String email = (String)dataBaseManager.resultList.get(0).get("email");



                        email_T.setText("");
                        password_T.setText("");


                        switch (accountType)
                        {
                            case "student":
                                System.out.println("Tworze konto studenta.");
                                StartingPoint_Main.globalUser = new Student(name,surname,email);
                                StartingPoint_Main.changeScene("STUDENT MENU", new Student_Menu().getStudent_Menu());
                                break;
                            case "lecturer":
                                System.out.println("Tworze konto wykladowcy.");
                                StartingPoint_Main.globalUser = new Lecturer(name,surname,email);
                                StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
                                break;
                            case "administrator":
                                System.out.println("Tworze konto admina.");
                                StartingPoint_Main.globalUser = new Administrator(name,surname,email);
                                StartingPoint_Main.changeScene("ADMINISTRATOR MENU", new Administrator_Menu().getAdministratorMenu());
                                break;

                        }



                    }
                    else
                    {
                        System.out.println("Podano nie poprawne dane! :-(");
                        Toast.makeToast("INCORRECT EMAIL OR PASSWORD");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });
        grid.add(button, 2, 3);     //  dodaje przycisk do widoku


        //  END BUTTON



        scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }



    @Override
    public void start(Stage primaryStage) throws Exception{


        Scene scene = new Login().getLoginScene();
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}

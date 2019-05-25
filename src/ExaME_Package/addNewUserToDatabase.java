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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






/*
Plik ze GUI dla dodawania nowego użytkownika ( Administrator Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI
18.05.2019 - Kopera - zrobienie wstepnego interfejsu



LIST OF THING TO IMPROVE/ADD

* ustawic limit znaków jaki można wpisać do okienka na takie jak to zostało określone w wymaganiach funkcjonalnych
* wyswietlanie komunikatu ze email jest nieprawidlowy
* ewentualie validacja hasła (długość, musi zawierać cyfry) i wyświetlanie komunikatu
* DESIGN - COLORS, FONTS


 */


public class
addNewUserToDatabase extends Application {

    public ArrayList<User> users = new ArrayList<>();


    public void viewUsers()
    {
        for (User u: users)
        {
            System.out.println(u);
        }
    }



    //  funkcja validateEmail zwroci true jesli to co zostalo podane to email
    //  jesli to niepoprawny adres email - zwroci false

    // Poprawny format emaila: ZNAKI MAŁPA ZNAKI KROPKA ZNAKI
    //  np. janusznosacz2@onet.pl


    public Boolean validateEmail(String email)
    {
        String emailRegex = ".+@.+\\..+";
        Pattern p = Pattern.compile(emailRegex);

            Matcher m = p.matcher(email);
            return m.matches();
    }




    public Scene getAddNewUserToDatabase()
    {

        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("CREATE NEW USER ACCOUNT"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element


        Label name_L = new Label("NAME:");
        grid.add(name_L, 0, 1);

        TextField name_T = new TextField();
        grid.add(name_T, 1, 1);



        Label surname_L = new Label("SURNAME:");
        grid.add(surname_L, 0, 2);


        TextField surname_T = new TextField();
        grid.add(surname_T, 1, 2);


        Label email_L = new Label("EMAIL:");
        grid.add(email_L, 0, 3);

        TextField email_T = new TextField();
        grid.add(email_T, 1, 3);



        Label password_L = new Label("PASSWORD:");
        grid.add(password_L, 0, 4);

        PasswordField password_T = new PasswordField();
        grid.add(password_T, 1, 4);

        Label accountType_L = new Label("ACCOUNT TYPE:");
        grid.add(accountType_L, 0, 5);

        TextField accountType_T = new TextField();
        grid.add(accountType_T, 1, 5);




        //  BUTTON

        Button button = new Button();
        button.setText("CREATE ACCOUNT");

        //  Ustawiam co ma sie dziac po nacisnieciu przycisku
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                //  Wykonuje operacje jeżeli podany email jest prawidłowy

                if(validateEmail(email_T.getText()))
                {
                    User newUser = new  User(name_T.getText(), surname_T.getText(), email_T.getText(), password_T.getText());

                    users.add(newUser);


                   // String sgl = "INSERT INTO `uzytkowniki` (`id`, `imie`, `nazwisko`, `email`, `haslo`, `dostep`, `index`) VALUES (1, 'Tomasz', 'Gwizdalla', 'tgwizd@gmail.com', 'admin', 'administrator', NULL);";
                    String sgl = "INSERT INTO `uzytkowniki` (`id`, `imie`, `nazwisko`, `email`, `haslo`, `dostep`, `index`) VALUES (1, '" + name_T.getText() + "', '" + surname_T.getText() + "', '" + email_T.getText() + "', '" + password_T.getText() + "', '" + accountType_T.getText() + "', " + "NULL" + ");";

                    DataBaseManager dataBaseManager = null;
                    try {
                        dataBaseManager = new DataBaseManager();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    dataBaseManager.sendQuery_SET(sgl);




                    String sgl2 = "SELECT * FROM `uzytkowniki`";
                    dataBaseManager.sendQuery_GET(sgl2);    //  To potem usunac
                    for( Map<String, Object> temp : dataBaseManager.resultList) {
                        System.out.println(temp.values());
                    }




                    viewUsers();
                    System.out.println();

                    name_T.setText("");
                    surname_T.setText("");
                    email_T.setText("");
                    password_T.setText("");
                    accountType_T.setText("");

                }
                else
                {
                    System.out.println("Podano nie poprawny email! :-(");
                }


            }
        });
        grid.add(button, 1, 9);     //  dodaje przycisk do widoku


        //  END BUTTON



        Scene scene = new Scene(grid, 1600,900);

        return scene;
    }






    @Override
    public void start(Stage primaryStage) throws Exception{


        Scene scene = new addNewUserToDatabase().getAddNewUserToDatabase();
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());
        primaryStage.setTitle("ADD NEW USER TO DATABASE");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

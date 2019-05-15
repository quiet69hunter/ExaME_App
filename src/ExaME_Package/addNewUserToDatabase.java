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
Plik ze GUI dla dodawania pytania ( Lecturer Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI i metody addQuestion od nowa w JavaFX



LIST OF THING TO IMPROVE/ADD

* ustawic limit znaków jaki można wpisać do okienka na takie jak to zostało określone w wymaganiach funkcjonalnych
* DESIGN - COLORS, FONTS


 */


public class addNewUserToDatabase extends Application {

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


    public Boolean validateEmail(String email)
    {
        String emailRegex = ".+@.+\\..+";
        Pattern p = Pattern.compile(emailRegex);




            Matcher m = p.matcher(email);
            return m.matches();
    }




    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("ADD NEW USER TO DATABASE");


        //  GRID

        var grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);         //  Horizontal gap
        grid.setVgap(20);          //  Vertical gap

        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("CREATE NEW USER ACCOUNT"); //   Tekst
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
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





        primaryStage.setScene(new Scene(grid, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

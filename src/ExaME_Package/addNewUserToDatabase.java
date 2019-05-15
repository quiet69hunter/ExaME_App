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


    public void viewQuestions()
    {
        for (User u: users)
        {
            System.out.println(u);
        }
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

//                // Pola questionNum i correctAnswer sa do poprawy
//
//                Integer questionNum = 1;
//                Integer correctAnswer = 1;
//
//
//
//                //  Tak wyglada konstruktor Question:
//                //Question(Integer questionNumber, String questionContent, ArrayList<String> answers, Integer correctAnswer, Integer pointsForCorrectAnswer, Integer pointsForWrongAnswer)
//
//                ArrayList<String> answers = new ArrayList<>();
//                answers.add(answerA_T.getText());
//                answers.add(answerB_T.getText());
//                answers.add(answerC_T.getText());
//                answers.add(answerD_T.getText());
//
//                Integer pointsForCorrectAnswer = 1;
//                Integer pointsForWrongAnswer = 1;
//
//                if(!correctAnswer_T.getText().toString().isEmpty())
//                {
//                    pointsForCorrectAnswer = Integer.parseInt(correctAnswer_T.getText());
//                }
//                if(!wrongAnswer_T.getText().toString().isEmpty())
//                {
//                    pointsForWrongAnswer = Integer.parseInt(wrongAnswer_T.getText());
//                }
//
//
//                Question q = new Question(questionNum, questionContent_T.getText(), answers, correctAnswer, pointsForCorrectAnswer, pointsForWrongAnswer);
//                questions.add(q);
//
//                viewQuestions();
//                System.out.println();
//
//                questionContent_T.setText("");
//
//                answerA_T.setText("");
//                answerB_T.setText("");
//                answerC_T.setText("");
//                answerD_T.setText("");
//
//                correctAnswer_T.setText("");
//                wrongAnswer_T.setText("");
//







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

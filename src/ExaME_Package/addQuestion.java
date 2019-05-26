package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;






/*
Plik ze GUI dla dodawania pytania ( Lecturer Module )



UPDATES

15.05.2019 - Kotecki - otworzenie GUI i metody addQuestion od nowa w JavaFX
16.05.2019 - Kopera - test2
16.05.2019 - Kotecki - test3
18.05.2019 - Kopera - zrobienie wstepnego interfejsu


LIST OF THING TO IMPROVE/ADD

* trzeba połączyć wszystkie radioButtons w radioGroup
* ustawic limit znaków jaki można wpisać do okienka na takie jak to zostało określone w wymaganiach funkcjonalnych
* DESIGN - COLORS, FONTS


 */







public class addQuestion extends Application {

    public ArrayList<Question> questions = new ArrayList<>();


    public void viewQuestions()
    {
        for (Question q: questions)
        {
            System.out.println(q);
        }
    }



    public Scene getAddQuestion()
    {

        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("CREATE QUESTION"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element


        Label questionContent_L = new Label("ADD QUESTION CONTENT:");
        grid.add(questionContent_L, 0, 1);

        TextField questionContent_T = new TextField();
        grid.add(questionContent_T, 1, 1);



        Label answerA_L = new Label("ANSWER A:");
        grid.add(answerA_L, 0, 2);

        TextField answerA_T = new TextField();
        grid.add(answerA_T, 1, 2);



        Label answerB_L = new Label("ANSWER B:");
        grid.add(answerB_L, 0, 3);

        TextField answerB_T = new TextField();
        grid.add(answerB_T, 1, 3);



        Label answerC_L = new Label("ANSWER C:");
        grid.add(answerC_L, 0, 4);

        TextField answerC_T = new TextField();
        grid.add(answerC_T, 1, 4);



        Label answerD_L = new Label("ANSWER D:");
        grid.add(answerD_L, 0, 5);

        TextField answerD_T = new TextField();
        grid.add(answerD_T, 1, 5);




        Label correctAnswer_L = new Label("POINTS FOR CORRECT ANSWER:");
        grid.add(correctAnswer_L, 0, 6);

        TextField correctAnswer_T = new TextField();
        grid.add(correctAnswer_T, 1, 6);


        Label wrongAnswer_L = new Label("POINTS FOR WRONG ANSWER:");
        grid.add(wrongAnswer_L, 0, 7);

        TextField wrongAnswer_T = new TextField();
        grid.add(wrongAnswer_T, 1, 7);


        Label indexOFCorrectAnswer_L = new Label("CORRECT ANSWER IS:");
        grid.add(indexOFCorrectAnswer_L, 0, 8);

        TextField indexOFCorrectAnswer_T = new TextField();
        grid.add(indexOFCorrectAnswer_T, 1, 8);



        //  BUTTON

        Button button = new Button();
        button.setText("Add this question to test");


        //  Ustawiam co ma sie dziac po nacisnieciu przycisku
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                // Pola questionNum i correctAnswer sa do poprawy

                Integer questionNum = 1;
                Integer correctAnswer = 1;

                Integer correctA=0;
                Integer correctB=0;
                Integer correctC=0;
                Integer correctD=0;




                //  Tak wyglada konstruktor Question:
                //Question(Integer questionNumber, String questionContent, ArrayList<String> answers, Integer correctAnswer, Integer pointsForCorrectAnswer, Integer pointsForWrongAnswer)

                ArrayList<String> answers = new ArrayList<>();
                answers.add(answerA_T.getText());
                answers.add(answerB_T.getText());
                answers.add(answerC_T.getText());
                answers.add(answerD_T.getText());

                Integer pointsForCorrectAnswer = 0;
                Integer pointsForWrongAnswer = 0;

                if(!correctAnswer_T.getText().toString().isEmpty())
                {
                    pointsForCorrectAnswer = Integer.parseInt(correctAnswer_T.getText());
                }
                if(!wrongAnswer_T.getText().toString().isEmpty())
                {
                    pointsForWrongAnswer = Integer.parseInt(wrongAnswer_T.getText());
                }

                Integer pointsA=pointsForWrongAnswer;
                Integer pointsB=pointsForWrongAnswer;
                Integer pointsC=pointsForWrongAnswer;
                Integer pointsD=pointsForWrongAnswer;

                //przypisywanie prawidłowej odpowiedzi
                if( indexOFCorrectAnswer_T.getText().equals("a") ||  indexOFCorrectAnswer_T.getText().equals("A"))
                {
                     correctA=1;
                    pointsA=pointsForCorrectAnswer;
                }
                else  if(  indexOFCorrectAnswer_T.getText().equals("b") ||  indexOFCorrectAnswer_T.getText().equals("B"))
                {
                    correctB=1;
                    pointsB=pointsForCorrectAnswer;
                }
                else  if(  indexOFCorrectAnswer_T.getText().equals("c") ||  indexOFCorrectAnswer_T.getText().equals("C"))
                {
                    correctC=1;
                    pointsC=pointsForCorrectAnswer;
                }
                else  if( indexOFCorrectAnswer_T.getText().equals("d") ||  indexOFCorrectAnswer_T.getText().equals("D"))
                {
                    correctD=1;
                    pointsD=pointsForCorrectAnswer;
                }


                DataBaseManager dataBaseManager = null;
                try {
                    dataBaseManager = new DataBaseManager();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //  question content
                String sql = "INSERT INTO `question` (`idTest`, `questionContent`) VALUES ("+ ((Lecturer)(StartingPoint_Main.globalUser)).newTestID  + ", '"+ questionContent_T.getText() +"');";
                dataBaseManager.sendQuery_SET(sql);


                sql = "SELECT question.id FROM question WHERE question.questionContent='" + questionContent_T.getText() + "'";
                dataBaseManager.sendQuery_GET(sql);

                String idQ = dataBaseManager.resultList.get(0).get("id").toString();
                System.out.println("Id nowego pytania to: " + idQ);



                // dodać lambdę tutaj

                //poprawic id testu
                sql = "INSERT INTO `answer`(`idQuestion`, `answerContent`, `answerIsCorrect`, `pointOfAnswer`, `ABCD`) VALUES ("+ idQ + ",'" + answerA_T.getText() + "','"+correctA+"','"+pointsA+"','A');";
                dataBaseManager.sendQuery_SET(sql);

                sql = "INSERT INTO `answer`(`idQuestion`, `answerContent`, `answerIsCorrect`, `pointOfAnswer`, `ABCD`) VALUES ("+ idQ + ",'" + answerB_T.getText() + "','"+correctB+"','"+pointsB+"','B');";
                dataBaseManager.sendQuery_SET(sql);

                sql = "INSERT INTO `answer`(`idQuestion`, `answerContent`, `answerIsCorrect`, `pointOfAnswer`, `ABCD`) VALUES ("+ idQ + ",'" + answerC_T.getText() + "','"+correctC+"','"+pointsC+"','C');";
                dataBaseManager.sendQuery_SET(sql);

                sql = "INSERT INTO `answer`(`idQuestion`, `answerContent`, `answerIsCorrect`, `pointOfAnswer`, `ABCD`) VALUES ("+ idQ + ",'" + answerD_T.getText() + "','"+correctD+"','"+pointsD+"','D');";
                dataBaseManager.sendQuery_SET(sql);


                Question q = new Question(questionNum, questionContent_T.getText(), answers, correctAnswer, pointsForCorrectAnswer, pointsForWrongAnswer);
                questions.add(q);

                viewQuestions();
                System.out.println();



                questionContent_T.setText("");

                answerA_T.setText("");
                answerB_T.setText("");
                answerC_T.setText("");
                answerD_T.setText("");

                correctAnswer_T.setText("");
                wrongAnswer_T.setText("");
                indexOFCorrectAnswer_T.setText("");


                if(((Lecturer)(StartingPoint_Main.globalUser)).questionCounter < ((Lecturer)(StartingPoint_Main.globalUser)).numOfQuestionsInTest)
                {
                    ((Lecturer)(StartingPoint_Main.globalUser)).questionCounter++;
                    Toast.makeToast("THE QUESTION WAS SUCCESSFULLY ADDED TO THE DATABASE");
                }
                else
                {
                    ((Lecturer)(StartingPoint_Main.globalUser)).questionCounter = 1;
                    ((Lecturer)(StartingPoint_Main.globalUser)).numOfQuestionsInTest = 0;
                    ((Lecturer)(StartingPoint_Main.globalUser)).newTestID = "";

                    Toast.makeToast("YOU ADDED TOTAL AMOUNT OF QUESTIONS TO THIS TEST. \n THE TEST WAS SUCCESSFULLY ADDED TO THE DATABASE");

                    StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
                }




            }
        });
        grid.add(button, 1, 9);     //  dodaje przycisk do widoku


        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("addQuestion");




        // w taki sposob odbywa sie zmiana sceny;

        Scene scene = new addQuestion().getAddQuestion();
        primaryStage.setScene(scene);
        primaryStage.setTitle("ADD QUESTION");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

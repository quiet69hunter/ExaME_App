package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;



/*
Plik z GUI dla rozwiązywania testu
UPDATES

26.05.2019 -Kopera - utworzenie klasy


LIST OF THING TO IMPROVE/ADD


 */

public class SolvingTheTest extends Application{


    public Scene getSolvingTheTest() throws ClassNotFoundException{

        GridPane grid = new GridPane();
        grid.setId("grid");



        Text scenetitle = new Text("TEST TITLE");
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label questionContent_T= new Label("TRESC PYTANIA");
        grid.add(questionContent_T,0,1);


        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("ODPOWIEDZ A");
        rb1.setToggleGroup(group);
        grid.add(rb1, 0, 2);

        RadioButton rb2 = new RadioButton("ODPOWIEDZ B");
        rb2.setToggleGroup(group);
        grid.add(rb2, 0, 3);

        RadioButton rb3 = new RadioButton("ODPOWIEDZ C");
        rb3.setToggleGroup(group);
        grid.add(rb3, 0, 4);

        RadioButton rb4 = new RadioButton("ODPOWIEDZ D");
        rb4.setToggleGroup(group);
        grid.add(rb4, 0, 5);



        DataBaseManager dataBaseManager = new DataBaseManager();


        String idTest =((Student)(StartingPoint_Main.globalUser)).idTest;
        String sql="SELECT questionContent FROM question WHERE idTest = '" + idTest + "';";
        dataBaseManager.sendQuery_GET(sql);


        sql = "SELECT test.id, test.testTitle, test.testQuestionsAmount, test.timeLimit, question.id, question.questionContent, answer.answerContent, answer.answerIsCorrect, answer.pointOfAnswer, answer.ABCD FROM test JOIN question ON question.idTest=test.id JOIN answer ON answer.idQuestion=question.id WHERE test.id='" + idTest + "';";


        //  id
        //  testTitle
        //  testQuestionsAmount
        //  timeLimit
        //  accessKey
        //  subject
        //  idLecturer


        dataBaseManager.sendQuery_GET(sql);

        System.out.println(dataBaseManager.resultList.get(0).keySet());

        dataBaseManager.printResultList();

        Test tempTest = new Test();

       // for(Map<String, Object> map : dataBaseManager.resultList)

        for(int i=0; i < dataBaseManager.resultList.size(); i += 4)
        {

            Question tempQuestion = new Question();


            Map<String, Object> map = dataBaseManager.resultList.get(i);

            Integer timeLimit = Integer.parseInt(map.get("timeLimit").toString());
            String questionContent = map.get("questionContent").toString();
            String answerIsCorrect;
            Integer pointOfAnswer = Integer.parseInt(map.get("pointOfAnswer").toString());
            String testTitle = map.get("testTitle").toString();


            tempTest.setTitle(testTitle);
            tempTest.setTestTime(timeLimit);

            tempQuestion.questionContent = questionContent;
            tempQuestion.pointsForWrongAnswer = pointOfAnswer;


            //  tresc pytan

            String answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
             answerIsCorrect = map.get("answerIsCorrect").toString();
            if(answerIsCorrect == "true") {
            tempQuestion.correctAnswer = 0;
            tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }

            map = dataBaseManager.resultList.get(i+1);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 1;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }


            map = dataBaseManager.resultList.get(i+2);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 2;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }



            map = dataBaseManager.resultList.get(i+3);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 3;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }




            //tempQuestion.answers.add(map.get(""));

            tempTest.questions.add(tempQuestion);

        }

        System.out.println();
        System.out.println();




        ((Student)(StartingPoint_Main.globalUser)).test = tempTest;
        System.out.println( ((Student)(StartingPoint_Main.globalUser)).test );

        //  BUTTON

        Button button_NextQuestion = new Button();
        button_NextQuestion.setText("Next question");





        button_NextQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {



            }
        });
        grid.add(button_NextQuestion, 1, 7);


        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);
        scene.getStylesheets().add(SolvingTheTest.class.getResource("Style.css").toExternalForm());

        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new SolvingTheTest().getSolvingTheTest();
        primaryStage.setScene(scene);
        primaryStage.setTitle("TEST");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

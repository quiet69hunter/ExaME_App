package ExaME_Package;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



/*
Plik z GUI dla rozwiązywania testu
UPDATES

26.05.2019 -Kopera - utworzenie klasy


LIST OF THING TO IMPROVE/ADD


 */

public class SolvingTheTest extends Application{


    public Scene getSolvingTheTest() throws ClassNotFoundException, IOException {

        GridPane grid = new GridPane();
        grid.setId("grid");



        Text scenetitle = new Text("TEST TITLE");
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);






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
            String testTitle = map.get("testTitle").toString();


            tempTest.setTitle(testTitle);
            tempTest.setTestTime(timeLimit);

            tempQuestion.questionContent = questionContent;



            //  tresc pytan

            String answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
             answerIsCorrect = map.get("answerIsCorrect").toString();
            Integer pointOfAnswer = Integer.parseInt(map.get("pointOfAnswer").toString());
            if(answerIsCorrect == "true") {
            tempQuestion.correctAnswer = 0;
            tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }
            else
            {
                tempQuestion.pointsForWrongAnswer = pointOfAnswer;
            }

            map = dataBaseManager.resultList.get(i+1);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            pointOfAnswer = Integer.parseInt(map.get("pointOfAnswer").toString());
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 1;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }
            else
            {
                tempQuestion.pointsForWrongAnswer = pointOfAnswer;
            }

            map = dataBaseManager.resultList.get(i+2);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            pointOfAnswer = Integer.parseInt(map.get("pointOfAnswer").toString());
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 2;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }
            else
            {
                tempQuestion.pointsForWrongAnswer = pointOfAnswer;
            }


            map = dataBaseManager.resultList.get(i+3);
            answerContent = map.get("answerContent").toString();
            tempQuestion.answers.add(answerContent);
            answerIsCorrect = map.get("answerIsCorrect").toString();
            pointOfAnswer = Integer.parseInt(map.get("pointOfAnswer").toString());
            if(answerIsCorrect == "true") {
                tempQuestion.correctAnswer = 3;
                tempQuestion.pointsForCorrectAnswer = pointOfAnswer;
            }
            else
            {
                tempQuestion.pointsForWrongAnswer = pointOfAnswer;
            }



            //tempQuestion.answers.add(map.get(""));

            tempTest.questions.add(tempQuestion);

        }

        System.out.println();
        System.out.println();




        ((Student)(StartingPoint_Main.globalUser)).test = tempTest;
        System.out.println( ((Student)(StartingPoint_Main.globalUser)).test );




        Integer curQue = ((Student)(StartingPoint_Main.globalUser)).currentQuestion;


        Label questionContent_T= new Label(((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).questionContent);
        grid.add(questionContent_T,0,1);

        final ToggleGroup group = new ToggleGroup();



        RadioButton rb1 = new RadioButton(((Student)(StartingPoint_Main.globalUser)).test.questions.get( curQue).answers.get(0) );
        rb1.setToggleGroup(group);
        grid.add(rb1, 0, 2);

        RadioButton rb2 = new RadioButton(((Student)(StartingPoint_Main.globalUser)).test.questions.get( curQue).answers.get(1) );
        rb2.setToggleGroup(group);
        grid.add(rb2, 0, 3);

        RadioButton rb3 = new RadioButton(((Student)(StartingPoint_Main.globalUser)).test.questions.get( curQue).answers.get(2) );
        rb3.setToggleGroup(group);
        grid.add(rb3, 0, 4);

        RadioButton rb4 = new RadioButton(((Student)(StartingPoint_Main.globalUser)).test.questions.get( curQue).answers.get(3) );
        rb4.setToggleGroup(group);
        grid.add(rb4, 0, 5);





        //  BUTTON

        Button button_NextQuestion = new Button();
        button_NextQuestion.setText("Next question");





        button_NextQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {


                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                ObservableList<Toggle> list = group.getToggles();
                if(selectedRadioButton == list.get(0) && ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).correctAnswer == 0)
                {
                    System.out.println("Wybrano przyciek 0");
                    ((Student)(StartingPoint_Main.globalUser)).Score += ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).pointsForCorrectAnswer;
                }
                else if(selectedRadioButton == list.get(1) && ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).correctAnswer == 1)
                {
                    System.out.println("Wybrano przyciek 1" );
                    ((Student)(StartingPoint_Main.globalUser)).Score += ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).pointsForCorrectAnswer;
                }
                else if(selectedRadioButton == list.get(2) && ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).correctAnswer == 2)
                {
                    System.out.println("Wybrano przyciek 2");
                    ((Student)(StartingPoint_Main.globalUser)).Score += ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).pointsForCorrectAnswer;
                }
                else if(selectedRadioButton == list.get(3) && ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).correctAnswer == 3)
                {
                    System.out.println("Wybrano przyciek 3");
                    ((Student)(StartingPoint_Main.globalUser)).Score += ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).pointsForCorrectAnswer;
                }
                else
                {
                    ((Student)(StartingPoint_Main.globalUser)).Score += ((Student)(StartingPoint_Main.globalUser)).test.questions.get(curQue).pointsForWrongAnswer;
                }


                ((Student)(StartingPoint_Main.globalUser)).currentQuestion++;
                System.out.println("Uzyskana ilosc punktow" + ((Student)(StartingPoint_Main.globalUser)).Score.toString());


                if(((Student)(StartingPoint_Main.globalUser)).currentQuestion < ((Student)(StartingPoint_Main.globalUser)).test.questions.size()) {
                    try {
                        StartingPoint_Main.changeScene("SOLVE QUESTIONS", new SolvingTheTest().getSolvingTheTest());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    try {
                        StartingPoint_Main.changeScene("YOUR SCORE", new Student_FinishTest().getStudent_FinishTest());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

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

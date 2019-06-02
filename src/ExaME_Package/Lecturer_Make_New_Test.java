package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*



UPDATES

26.05.2019 - Kopera - poprawki w połaczeniu z bazą


LIST OF THING TO IMPROVE/ADD


 */
public class Lecturer_Make_New_Test {




    //  Sprawdza czy podany String może być sparsowany do Inta
    private Boolean validateNumberInput(String stringToParse )
    {
        String numberRegex = "\\d+";
        Pattern p = Pattern.compile(numberRegex);

        Matcher m = p.matcher(stringToParse);
        return m.matches();
    }

    public Scene getLecturerMAekeNewTest() {
        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MAKE NEW TEST"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element




        Label title_L = new Label("TITLE:");
        grid.add(title_L, 0, 1);

        TextField title_T = new TextField();
        grid.add(title_T, 1, 1);


        Label subjectName_L = new Label("SUBJECT NAME:");
        grid.add(subjectName_L, 0, 2);

        TextField subjectName_T = new TextField();
        grid.add(subjectName_T, 1, 2);


        Label numberOfQuestions_L = new Label("NUMBER OF QUESTIONS:");
        grid.add(numberOfQuestions_L, 0, 3);

        TextField numberOfQuestions_T = new TextField();
        grid.add(numberOfQuestions_T, 1, 3);


        Label timeLimit_L = new Label("TIME LIMIT:");
        grid.add(timeLimit_L, 0, 4);

        TextField timeLimit_T = new TextField();
        grid.add(timeLimit_T, 1, 4);





        Button button_addQuestionsToTest = new Button();
        button_addQuestionsToTest.setText("ADD QUESTIONS TO TEST");
        button_addQuestionsToTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {

                    if (!timeLimit_T.getText().isEmpty() && !numberOfQuestions_T.getText().isEmpty() && validateNumberInput(numberOfQuestions_T.getText()) && validateNumberInput(timeLimit_T.getText()))
                    {

                        Integer timeLimit = Integer.parseInt(timeLimit_T.getText());
                        Integer numOfQ = Integer.parseInt(numberOfQuestions_T.getText());
                        ((Lecturer)(StartingPoint_Main.globalUser)).numOfQuestionsInTest = numOfQ;

                        Test t = new Test(title_T.getText(),subjectName_T.getText(),numOfQ,timeLimit);

                        DataBaseManager dataBaseManager = new DataBaseManager();
                        String sql = "INSERT INTO `test`( `testTitle`,`testQuestionsAmount`, `timeLimit`, `accessKey`, `subject`, `idLecturer`) VALUES ('" + title_T.getText() + "','" + numOfQ + "', '" + timeLimit + "','"+t.getKey()+"','" + subjectName_T.getText() + "'," + StartingPoint_Main.globalUser.ID +");";

                        dataBaseManager.sendQuery_SET(sql);


                        sql = "SELECT test.id FROM test WHERE test.testTitle='" + title_T.getText() + "' AND test.accessKey='"+ t.getKey() +"';";
                        dataBaseManager.sendQuery_GET(sql);
                        String idT = dataBaseManager.resultList.get(0).get("id").toString();
                        System.out.println("Id nowego tetu to: " + idT);

                        StartingPoint_Main.changeScene("ADD QUESTION", new addQuestion().getAddQuestion());

                        ((Lecturer)(StartingPoint_Main.globalUser)).newTestID = idT;

                    }
                    else
                    {
                        Toast.makeToast("INCORRECT INPUT OR SOME FIELDS ARE EMPTY");
                    }





                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        grid.add(button_addQuestionsToTest, 0, 5);
        //  END BUTTON



        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
            }
        });

        grid.add(button_GoBack, 0, 7);
        //  END BUTTON


        Scene scene = new Scene(grid, 1600, 900);
        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


}

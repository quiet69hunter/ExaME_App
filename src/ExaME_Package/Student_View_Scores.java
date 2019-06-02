package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Student_View_Scores {

    public Scene getStudent_View_Scores() throws ClassNotFoundException, IOException {
        //  GRID


        DataBaseManager dataBaseManager = new DataBaseManager();
        String sql = "SELECT test.subject, test.testTitle, mark.mark FROM mark JOIN test ON test.id=mark.idTest WHERE mark.idStudent=" + StartingPoint_Main.globalUser.ID + ";";
        dataBaseManager.sendQuery_GET(sql);


        dataBaseManager.printResultList();
        System.out.println(dataBaseManager.resultList.get(0).keySet());







        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 30, 0, 2, 1);





        Label subject_LF = new Label("SUBJECT");
        grid.add(subject_LF, 30, 1);

        Label title_LF = new Label("TITLE");
        grid.add(title_LF, 31, 1);

        Label score_LF = new Label("SCORE");
        grid.add(score_LF, 32, 1);






        for(int i=0; i < dataBaseManager.resultList.size(); ++i)
        {


            Label subject_L = new Label(dataBaseManager.resultList.get(i).get("subject").toString());
            grid.add(subject_L, 30, i+2);

            Label title_L = new Label(dataBaseManager.resultList.get(i).get("testTitle").toString());
            grid.add(title_L, 31, i+2);

            Label score_L = new Label(dataBaseManager.resultList.get(i).get("mark").toString());
            grid.add(score_L, 32, i+2);

        }




        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("STUDENT MENU", new Student_Menu().getStudent_Menu());
            }
        });
        grid.add( button_GoBack, 30, dataBaseManager.resultList.size()+5);
        //  END BUTTON




        StackPane imageHolder = new StackPane(grid);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(imageHolder);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(scrollPane, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }
}

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

public class Lecturer_ViewTestIDs {




    public Scene getLecturer_ViewTestIDs() throws ClassNotFoundException, IOException {
        //  GRID


        DataBaseManager dataBaseManager = new DataBaseManager();
        String sql = "SELECT test.id, test.accessKey, test.testTitle FROM test WHERE test.idLecturer=" + StartingPoint_Main.globalUser.ID.toString() + ";";
        dataBaseManager.sendQuery_GET(sql);


        dataBaseManager.printResultList();





        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 30, 0, 2, 1);





        Label access_key_LF = new Label("ACCESS KEY");
        grid.add(access_key_LF, 30, 1);

        Label id_LF = new Label("ID");
        grid.add(id_LF, 31, 1);

        Label test_title_LF = new Label("TEST TITLE");
        grid.add(test_title_LF, 32, 1);






        for(int i=0; i < dataBaseManager.resultList.size(); ++i)
        {


            Label access_key_L = new Label(dataBaseManager.resultList.get(i).get("accessKey").toString());
            grid.add(access_key_L, 30, i+2);

            Label id_L = new Label(dataBaseManager.resultList.get(i).get("id").toString());
            grid.add(id_L, 31, i+2);

            Label test_title_L = new Label(dataBaseManager.resultList.get(i).get("testTitle").toString());
            grid.add(test_title_L, 32, i+2);

        }




        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
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

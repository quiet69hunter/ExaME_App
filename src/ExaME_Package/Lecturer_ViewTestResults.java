package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Lecturer_ViewTestResults {


    public Scene getLecturer_ViewTestResults() throws ClassNotFoundException {
        //  GRID


        DataBaseManager dataBaseManager = new DataBaseManager();
        String sql = "SELECT user.name, user.surname, mark.mark FROM mark JOIN user ON user.id=mark.idStudent WHERE mark.idTest=" + ((Lecturer)(StartingPoint_Main.globalUser)).testID_ToView + ";";
        dataBaseManager.sendQuery_GET(sql);


        dataBaseManager.printResultList();






        GridPane grid = new GridPane();
        grid.setId("grid");







        Label surname_LF = new Label("SURNAME");
        grid.add(surname_LF, 0, 1);

        Label name_LF = new Label("NAME");
        grid.add(name_LF, 1, 1);

        Label mark_LF = new Label("MARK");
        grid.add(mark_LF, 2, 1);






        for(int i=0; i < dataBaseManager.resultList.size(); ++i)
        {


            Label surname_L = new Label(dataBaseManager.resultList.get(i).get("surname").toString());
            grid.add(surname_L, 0, i+2);

            Label name_L = new Label(dataBaseManager.resultList.get(i).get("name").toString());
            grid.add(name_L, 1, i+2);

            Label mark_L = new Label(dataBaseManager.resultList.get(i).get("mark").toString());
            grid.add(mark_L, 2, i+2);

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
        grid.add( button_GoBack, 0, dataBaseManager.resultList.size()+5);
        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


}

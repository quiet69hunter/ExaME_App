package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Student_FinishTest
{


    public Scene getStudent_FinishTest() throws ClassNotFoundException {





        DataBaseManager dataBaseManager = new DataBaseManager();
        String sql = "INSERT INTO `mark`(`idTest`, `idStudent`, `dateOpen`, `dateClose`, `mark`) VALUES ('" + ((Student)(StartingPoint_Main.globalUser)).idTest  + "," + (StartingPoint_Main.globalUser).ID.toString() + ",NOW(),NOW()," + ((Student)(StartingPoint_Main.globalUser)).Score.toString() + ");";
        dataBaseManager.sendQuery_SET(sql);





        //  GRID



        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);





        Label subject_LF = new Label("YOUR SCORE IS:");
        grid.add(subject_LF, 0, 1);

        Label title_LF = new Label(((Student)(StartingPoint_Main.globalUser)).Score.toString());
        grid.add(title_LF, 0, 2);




        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("STUDENT MENU", new Student_Menu().getStudent_Menu());
            }
        });
        grid.add( button_GoBack, 0, 5);
        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


}

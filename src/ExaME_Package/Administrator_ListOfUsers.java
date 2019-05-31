package ExaME_Package;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Administrator_ListOfUsers {


    public Scene getAdministrator_ListOfUsers() throws ClassNotFoundException {
        //  GRID

        DataBaseManager dataBaseManager = new DataBaseManager();
        String sql = "SELECT id, name, surname,email, access FROM user;";
        dataBaseManager.sendQuery_GET(sql);






        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);




        Label id_LF = new Label("ID");
        grid.add(id_LF, 0, 1);

        Label name_LF = new Label("NAME");
        grid.add(name_LF, 1, 1);

        Label surname_LF = new Label("SURNAME");
        grid.add(surname_LF, 2, 1);

        Label email_LF = new Label("EMAIL");
        grid.add(email_LF, 3, 1);

        Label access_LF = new Label("ACCESS");
        grid.add(access_LF, 4, 1);




        for(int i=0; i < dataBaseManager.resultList.size(); ++i)
        {

            Label id_L = new Label(dataBaseManager.resultList.get(i).get("id").toString());
            grid.add(id_L, 0, i+2);

            Label name_L = new Label(dataBaseManager.resultList.get(i).get("name").toString());
            grid.add(name_L, 1, i+2);

            Label surname_L = new Label(dataBaseManager.resultList.get(i).get("surname").toString());
            grid.add(surname_L, 2, i+2);

            Label email_L = new Label(dataBaseManager.resultList.get(i).get("email").toString());
            grid.add(email_L, 3, i+2);

            Label access_L = new Label(dataBaseManager.resultList.get(i).get("access").toString());
            grid.add(access_L, 4, i+2);


        }




        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("ADMINISTRATOR MENU", new Administrator_Menu().getAdministratorMenu());
            }
        });
        grid.add( button_GoBack, 0, dataBaseManager.resultList.size()+5);
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

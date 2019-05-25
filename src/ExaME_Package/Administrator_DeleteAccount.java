package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class Administrator_DeleteAccount {
    public Scene getAdministratorMenu()
    {
        //  GRID

        GridPane grid = new GridPane();
        grid.setId("grid");

        Text scenetitle = new Text("MENU"); //   Tekst
        scenetitle.setId("mainTitle");
        grid.add(scenetitle, 0, 0, 2, 1);   //  Ustawiam w ktorym miejscu siatki ma byc dodany element




        Label info_L = new Label("PUT ID OF THE USER YOU WANT TO DELETE:");
        grid.add(info_L, 0, 1);

        TextField info_T = new TextField();
        grid.add(info_T, 0, 2);




        Button button_Delete = new Button();
        button_Delete.setText("DELETE");
        button_Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try {

                    DataBaseManager dataBaseManager = new DataBaseManager();
                    String sql = "DELETE FROM user WHERE user.id ="+ info_T.getText() + ";";
                    dataBaseManager.sendQuery_SET(sql);

                    Toast.makeToast("THE ACCOUNT WAS SUCCESSFULLY DELETED");


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        grid.add(button_Delete, 0, 3);
        //  END BUTTON



        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("ADMINISTRATOR MENU", new Administrator_Menu().getAdministratorMenu());
            }
        });
        grid.add( button_GoBack, 0, 4);
        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }

}

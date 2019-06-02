package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Lecturer_ChangeKey {


    public Scene getLecturer_ChangeKey() throws ClassNotFoundException {
        //  GRID


        GridPane grid = new GridPane();
        grid.setId("grid");


        Label Input_LF = new Label("TEST ID TO CHANGE KEY: ");
        grid.add(Input_LF, 0, 0);


        TextField Input_T = new TextField();
        grid.add(Input_T, 0, 1);

        Button button_Input = new Button();
        button_Input.setText("CHANGE");


        grid.add(button_Input, 0, 2);


        button_Input .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {

                long Key=System.currentTimeMillis()/1000;
                Input_T.setText("");
                DataBaseManager dataBaseManager = null;
                try {
                    dataBaseManager = new DataBaseManager();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String sql = "UPDATE `test` SET `accessKey`="+Key+"  WHERE id=" + Input_T.getText()  + ";";
                dataBaseManager.sendQuery_SET(sql);
            }
        });

        Button button_GoBack = new Button();
        button_GoBack.setText("GO BACK");
        button_GoBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
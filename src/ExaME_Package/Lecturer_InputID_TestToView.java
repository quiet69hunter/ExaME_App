package ExaME_Package;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lecturer_InputID_TestToView {



    //  Sprawdza czy podany String może być sparsowany do Inta
    private Boolean validateNumberInput(String stringToParse )
    {
        String numberRegex = "\\d+";
        Pattern p = Pattern.compile(numberRegex);

        Matcher m = p.matcher(stringToParse);
        return m.matches();
    }


    public Scene getLecturer_InputID_TestToView() throws ClassNotFoundException {
        //  GRID







        GridPane grid = new GridPane();
        grid.setId("grid");



        Label Input_LF = new Label("VIEW TEST RESULTS OF ID: ");
        grid.add(Input_LF, 0, 0);





        TextField Input_T = new TextField();
        grid.add(Input_T, 0, 1);

        Button button_Input = new Button();
        button_Input.setText("SHOW");
        button_Input.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (Input_T.getText().isEmpty())
                {
                    Toast.makeToast("INPUT AREA IS EMPTY");
                }
                else if(!validateNumberInput(Input_T.getText()))
                {
                    Toast.makeToast("INPUT IS NOT A NUMBER");
                }
                else
                {
                    ((Lecturer)(StartingPoint_Main.globalUser)).testID_ToView = Input_T.getText();
                    try {
                        StartingPoint_Main.changeScene("TEST RESULTS", new Lecturer_ViewTestResults().getLecturer_ViewTestResults() );
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                }


        });
        grid.add( button_Input, 0, 2);







        Button button_GoBack = new Button();
        button_GoBack .setText("GO BACK");
        button_GoBack .setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                StartingPoint_Main.changeScene("LECTURER MENU", new Lecturer_Menu().getLecturerMenu());
            }
        });
        grid.add( button_GoBack, 0, 7);
        //  END BUTTON




        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }


}

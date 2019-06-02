package ExaME_Package;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.security.util.Password;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstLaunch extends Application {





    private Boolean validateDatabase(String stringToParse )
    {
        String numberRegex = "jdbc:mysql.+";
        Pattern p = Pattern.compile(numberRegex);

        Matcher m = p.matcher(stringToParse);
        return m.matches();
    }



    public static void main(String[] args)

    {

        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {














            GridPane grid = new GridPane();
            grid.setId("grid");



            Label URL_LF = new Label("DATABASE URL: ");
            grid.add(URL_LF, 0, 0);

            TextField URL_T = new TextField();
            grid.add(URL_T, 1, 0);



        Label UserName_LF = new Label("DATABASE USER NAME: ");
        grid.add(UserName_LF, 0, 1);

        TextField UserName_T = new TextField();
        grid.add(UserName_T, 1, 1);


        Label Password_LF = new Label("DATABASE USER PASSWORD: ");
        grid.add(Password_LF, 0, 2);

        TextField Password_T = new TextField();
        grid.add(Password_T, 1, 2);

//        jdbc:mysql://sql.serwer1934053.home.pl:3306/30631950_spiochy
//        30631950_spiochy
//        1The2Sleepers3





            Button button_Input = new Button();
            button_Input.setText("SAVE");
            button_Input.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event)
                {
                    if (URL_T.getText().isEmpty() && UserName_T.getText().isEmpty() && Password_T.getText().isEmpty())
                    {
                        Toast.makeToast("INPUT AREA IS EMPTY");
                    }
                    else if(!validateDatabase(URL_T.getText()))
                    {
                        Toast.makeToast("INPUT URL IS INCORRECT");
                    }
                    else
                    {
                        System.out.println("URL is correct");

                        Toast.makeToast("THE CREDENCIALS WERE SUCCESSFULLY SAVED");


                        FileWriter fileWriter = null;
                        try {
                            fileWriter = new FileWriter("DatabaseCredentials.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.print(URL_T.getText() + "\n");
                        printWriter.print(UserName_T.getText() + "\n");
                        printWriter.print(Password_T.getText());
                        printWriter.close();
                    }
                }


            });
            grid.add( button_Input, 0, 5);











            Scene scene = new Scene(grid, 1600,900);
            scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());



        primaryStage.setTitle("ADD DATABASE");
        primaryStage.setScene(scene);

        primaryStage.show();



    }
}

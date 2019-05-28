package ExaME_Package;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Timer {


    private Timeline animationTimeline;
    private Integer TIME = 60;
    private String string = "";
    Label label = new Label("60");






    private void timeLabel_function()
    {
        if(TIME > 0)
        {
            TIME--;
        }
        string = TIME + "";
        label.setText(string);

    }





    public Scene getTimer() throws ClassNotFoundException {
        //  GRID





        Timer timer = new Timer();





        GridPane grid = new GridPane();
        grid.setId("grid");





        Label timer_L = label;
        timer_L.setFont(javafx.scene.text.Font.font(200));
        grid.add(timer_L, 0, 1);


        animationTimeline = new Timeline(new KeyFrame(Duration.seconds(1),e->timeLabel_function()));
        animationTimeline.setCycleCount(Timeline.INDEFINITE);
        animationTimeline.play();



        Scene scene = new Scene(grid, 1600,900);

        scene.getStylesheets().add(Login.class.getResource("Style.css").toExternalForm());

        return scene;
    }




}

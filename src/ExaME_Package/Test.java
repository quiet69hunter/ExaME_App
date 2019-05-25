package ExaME_Package;

import javafx.application.Application;

import java.util.ArrayList;

/*
Klasa reprezentująca pojedynczy test



UPDATES

15.05.2019 - Kotecki - otworzenie klasy
23.05.2019 - Kopera - dopisanie ciał metod



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */


public class Test  {

    private Integer testID;
    private ArrayList<Question> questions;
    private Float testTime;
    private Integer Key;
    private Integer MaxPoints;
    private String title;

    public Test(Integer testID, ArrayList<Question> questions, Float testTime, Integer Key, Integer MaxPointsString,String title)
    {
        this.testID=testID;
        this.questions=questions; //zastanowic sie
        this.testTime=testTime;
        this.Key=Key;
        this.MaxPoints=MaxPoints;
        this.title=title;
    }

    public void generateNewKey(Integer testID)
    {
        this.testID=testID;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public Float getTestTime() {
        return testTime;
    }

    public void setTestTime(Float testTime) {
        this.testTime = testTime;
    }

    public Integer getMaxPoints() {
        return MaxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        MaxPoints = maxPoints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

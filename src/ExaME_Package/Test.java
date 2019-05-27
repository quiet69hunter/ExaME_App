package ExaME_Package;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/*
Klasa reprezentująca pojedynczy test



UPDATES

15.05.2019 - Kotecki - otworzenie klasy
23.05.2019 - Kopera - dopisanie ciał metod



LIST OF THING TO IMPROVE/ADD


 */


public class Test  {

    //private Integer testID;
    public ArrayList<Question> questions;
    private Integer testTime;
    private long Key;
    private String title;
    private Integer questionAmount;
    private String nameOfSubject;


    public Test()
    {
        questions = new ArrayList<>();
    };

    public Test( String title,  String nameOfSubject, Integer questionAmount, Integer testTime)
    {
        this.title=title;
        this.nameOfSubject=nameOfSubject;
        this.questionAmount=questionAmount;
        this.testTime=testTime;
        this.Key=System.currentTimeMillis()/1000;
    }

    public void generateNewKey(Integer Key)
    {
        this.Key=Key;
    }


    public Integer getTestTime() {
        return testTime;
    }

    public void setTestTime(Integer testTime) {
        this.testTime = testTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getKey() {
        return Key;
    }

    public void setKey(long key) {
        Key = key;
    }


    @Override
    public String toString() {
        return "Test{" +
                "questions=" + questions +
                ", testTime=" + testTime +
                ", Key=" + Key +
                ", title='" + title + '\'' +
                ", questionAmount=" + questionAmount +
                ", nameOfSubject='" + nameOfSubject + '\'' +
                '}';
    }
}

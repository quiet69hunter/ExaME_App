package ExaME_Package;

import java.util.ArrayList;


/*
Klasa reprexentująca pojedynczego studenta



UPDATES

15.05.2019 - Kotecki - otworzenie klasy



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */


public class Student extends User {


    public String idTest; //dopisane
    public  Test test;
    private ArrayList<Integer> testIDs = new ArrayList<>();
    Integer Score = 0;
    Integer currentQuestion = 0;


    public Student(String name, String surname, String email, Integer id) {
        super(name, surname, email, id);
    }




    public Boolean startTest (Integer testKey)
    {

        if(true)
        {
            return true;
        }
        if(false)
        {
            return false;
        }
        return true;
    }



    public void answerQuestion(Integer choosenAnswer)
    {

    }


    public void finishTest()
    {

    }



    public void getScore()
    {

    }



    public void checkPreviousTestsScores()
    {

    }

}

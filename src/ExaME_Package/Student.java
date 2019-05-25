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


    private ArrayList<Integer> testIDs = new ArrayList<>();


    public Student(String name, String surname, String email) {
        super(name, surname, email);
    }




    public Boolean startTest (Integer testID)
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

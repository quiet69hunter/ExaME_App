package ExaME_Package;

import java.util.ArrayList;


/*
Klasa reprezentująca pojedynczego wykładowcę



UPDATES

15.05.2019 - Kotecki - otworzenie klasy



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */




public class Lecturer extends User {

    private ArrayList<Integer> testIDs = new ArrayList<>();
    private ArrayList<Integer> studentIDs = new ArrayList<>();



    public Boolean startMakingTest(Integer testID)
    {
      return true;
    }


    public void add_New_Question(Question question)
    {

    }


    public void submitTest()
    {

    }

    public Integer generateNewKeyForTest(Integer testID)
    {
        return 0;
    }


    public void viewTestIDs()
    {

    }


    public void viewTestResults(Integer testID)
    {

    }

}

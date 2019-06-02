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


    public Integer numOfQuestionsInTest = 0;
    public Integer questionCounter = 1;
    public String newTestID = "";
    public String testID_ToView = "";

    public Lecturer(String name, String surname, String email, Integer id) {
        super(name, surname, email, id);
    }

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

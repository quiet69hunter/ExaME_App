package ExaME_Package;

import java.util.ArrayList;



/*
Klasa reprezentująca pojedynczego Administratora



UPDATES

15.05.2019 - Kotecki - otworzenie klasy



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */


public class Administrator extends User {


    public Administrator(String name, String surname, String email, Integer id) {
        super(name, surname, email, id);
    }

    public void addNewAccount(User newUser, String accountType)
    {

    }

    public void changeAccountType(Integer userID, String accountType)
    {
        //  te funkcje ewentualnie możemy pominąć, bo dużo roboty przy tym

    }

    public void deleteAccount(Integer userID)
    {

    }
}

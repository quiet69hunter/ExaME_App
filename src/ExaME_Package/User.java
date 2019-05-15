package ExaME_Package;


/*
Klasa reprezentująca pojedynczego użytkownika.
Jest to klasa bazowa dla klas: Student, Lecturer, Administrator.



UPDATES

15.05.2019 - Kotecki - otworzenie klasy



LIST OF THING TO IMPROVE/ADD

* Uzupełnić ciała metod

 */



public class User {

    protected Integer id;
    protected String Name;
    protected String Surname;
    protected String Email;
    protected String Password;

    public User()
    {

    }

    public User(String name, String surname, String email, String password) {
        Name = name;
        Surname = surname;
        Email = email;
        Password = password;
    }

    public Boolean Login (String email, String Password)
    {
        //  Jeżeli podane dane są zgodne z tym co w bazie
        //  danych to funkcja zwraca true, jeżli nie - false.

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


    public Boolean LogOut()
    {
        //  Jeżeli próba wylogowania udała się,
        //  to funkcja zwraca true, jeżli nie - false.

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

}

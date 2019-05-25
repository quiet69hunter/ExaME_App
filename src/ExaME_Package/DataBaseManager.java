package ExaME_Package;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.*;


//  Klasa do zarzadzania baza danych

public class DataBaseManager {

    static final String Driver = "com.mysql.jdbc.Driver";

    static final String URL = "jdbc:mysql://sql.serwer1934053.home.pl:3306/30631950_spiochy";
    static final String UserName = "30631950_spiochy";
    static final String Password = "1The2Sleepers3";


    public List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
    public Map<String, Object> row = null;


    DataBaseManager() throws ClassNotFoundException {
        //  driver
        Class.forName("com.mysql.jdbc.Driver");

    }



    //  do wysyłania zapyrań do bazy używamy metody sendQuery(), ktora przyjmuje
    //  zapytanie w formie stringa
    //  to co zwroci zapytanie jest przechowywane w polu liście map zwanym resultList
    //  jedna mapa wkłada się z jednego zwróconego rekordu (np, id, nazwy, imienia)
    //  aby dostac sie do tych rzeczy należy podać mapie, tak jak bazie danych, np. "id" to zwroci, np 5.



    public void printResultList()
    {
        for( Map<String, Object> temp : resultList) {
            System.out.println(temp.values());
        }
    }

    public void sendQuery_GET(String sqlQuery)
    {
        resultList.clear();


            //  blok try-wth-resources
        try (
                Connection connection = getConnection(URL, UserName, Password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery)
        ){

            ResultSetMetaData metaData = resultSet.getMetaData();
            Integer columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                row = new HashMap<String, Object>();

                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                resultList.add(row);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public Boolean sendQuery_GET_BOOLEAN(String sqlQuery) throws SQLException {

        resultList.clear();


        //  blok try-wth-resources
        try (
                Connection connection = getConnection(URL, UserName, Password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery)
        ) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            Integer columnCount = metaData.getColumnCount();


            Long returnedValue = 1l;


            resultSet.next();
            returnedValue = (Long) resultSet.getObject(1);

            if(returnedValue == 1)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }



        public void sendQuery_SET(String sqlQuery)
    {
        resultList.clear();


        //  blok try-wth-resources
        try (
                Connection connection = getConnection(URL, UserName, Password);
                Statement statement = connection.createStatement();
        ){

            statement.executeUpdate(sqlQuery);

            } catch (SQLException e) {
            e.printStackTrace();
        }


    }





    public static void main(String[] args) throws NullPointerException, SQLException, ClassNotFoundException {

        DataBaseManager o = new DataBaseManager();

        String sqlQuery = "SELECT id, nazwa, id_uzytkownika FROM przedmiot";

        o.sendQuery_GET(sqlQuery);


        o.printResultList();

        System.out.println(o.resultList.get(0).get("nazwa"));

    }

}

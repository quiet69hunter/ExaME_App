package ExaME_Package;
import java.sql.*;


public class DataBase_Connector_Prototype {

    static  final String Driver = "com.mysql.jdbc.Driver";

    static  final String URL = "jdbc:mysql://sql.serwer1934053.home.pl:3306/30631950_spiochy";
    static  final String UserName = "30631950_spiochy";
    static  final String Password = "1The2Sleepers3";


    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try
        {

            //  driver

            Class.forName("com.mysql.jdbc.Driver");



            //  connect to database

            connection = DriverManager.getConnection( URL ,UserName, Password);




            //  execute query

            statement = connection.createStatement();
            String sqlQuery;

            sqlQuery = "SELECT id, nazwa, id_uzytkownika FROM przedmiot";
            ResultSet resultSet = statement.executeQuery(sqlQuery);


            while(resultSet.next())
            {
                Integer id = resultSet.getInt("id");
                Integer id_user = resultSet.getInt("id_uzytkownika");
                String nazwaPrzedmiotu = resultSet.getString("nazwa");

                System.out.println(id + " " + " " + id_user + " " + nazwaPrzedmiotu);


            }

            resultSet.close();
            connection.close();
            statement.close();



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

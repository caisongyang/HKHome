package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class testjdbc {
    public static void main(String[] args) {
        String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306?serverTimezone=GMT&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "qazwsx";

        try {
            Class.forName(DB_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("USE `world`");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `country`");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


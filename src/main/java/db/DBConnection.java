package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection connection = null;

//    public static Connection getConnection() {
//      try {
//          Class.forName("com.mysql.cj.jdbc.Driver");
//          connection = DriverManager.getConnection("jdbs:mysqql://localhost:3306/sheriyans","root","muskanrai@1127");
//      }catch (ClassNotFoundException | SQLException ex){
//          ex.printStackTrace();
//      }
//      return connection;
//    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheriyans", "root", "muskanrai@1127");
        }
        catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

//    public static void main(String[] args) {
//        DBConnection.getConnection();
//        System.out.println("Connection Done");
//    }
}


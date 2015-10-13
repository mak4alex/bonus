package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    
    static String localDB = "jdbc:mysql://localhost:3306/souvenirstore";
    static String localUser = "root";
    static String localPassword = "admin";
    
    static String remoteDB = "jdbc:mysql://sql2.freemysqlhosting.net:3306/sql292039";
    static String remoteUser = "sql292039";
    static String remotePassword = "uD3%kH6%";

    public static Connection getConnection() {
       Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(localDB, localUser, localPassword);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        return connection;
    }

}
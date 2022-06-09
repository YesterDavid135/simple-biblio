package ch.ydavid.simplebiblio.sqlHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class SqlHandler {

     private String url = "jdbc:mysql://192.168.30.135:3306/simpleBiblio";
     private String username = "admin";
     private String password = "password";

     /**
      * Provides Connection to the Mariadb Database
      *
      * @return Connection object
      * @throws SQLException On error
      */
     public Connection getConnection() throws SQLException {

         return DriverManager.getConnection(url, username, password);

     }
 }

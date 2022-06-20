package ch.ydavid.simplebiblio.sqlHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHandler {

     private String url = "jdbc:postgresql://192.168.30.34:5432/simpleBiblio";
     private Properties props = new Properties();


     /**
      * Provides Connection to the PostgreSQL Database
      *
      * @return Connection object
      * @throws SQLException On error
      */
     public Connection getConnection() throws SQLException {

         props.setProperty("user","postgres");
         props.setProperty("password","InfLb20.admin");
         return DriverManager.getConnection(url, props);

     }
 }

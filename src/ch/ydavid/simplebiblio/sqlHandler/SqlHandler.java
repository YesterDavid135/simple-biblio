package ch.ydavid.simplebiblio.sqlHandler;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHandler {


     private Properties props = new Properties();

     /**
      * Provides Connection to the PostgreSQL Database
      *
      * @return Connection object
      * @throws SQLException On error
      */
     public Connection getConnection() throws SQLException {

         try {
             InputStream in = SqlHandler.class.getResourceAsStream("config.properties");
             props.load(in);
             in.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         String connection = props.getProperty("connection");
         String user = props.getProperty("user");
         String password = props.getProperty("password");
         return DriverManager.getConnection(connection, user, password);

     }
 }

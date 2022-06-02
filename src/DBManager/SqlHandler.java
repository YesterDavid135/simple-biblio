package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHandler {

    private void loadDriver() {
        System.out.println("Loading Driver");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
    }


    public Connection getConnection() throws SQLException {

//        loadDriver();
        return DriverManager.getConnection("jdbc:mysql://192.168.30.135:3306/simpleBiblio", "admin", "password");

    }
}

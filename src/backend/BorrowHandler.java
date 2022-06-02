package backend;

import DBManager.SqlHandler;

import java.sql.*;

public class BorrowHandler {

    SqlHandler sqlhandler = new SqlHandler();

    public boolean borrowItem(int itemID, int userID) throws SQLException {


        String query = "INSERT INTO tbl_borrowed ( tbl_users_iduser, tbl_inventory_idMedia, returned) ";
        query += "VALUES (\"" + userID + "\", \"" + itemID + "\", false)";

        Connection connection = sqlhandler.getConnection();

        Statement stmt = connection.createStatement();

        return stmt.execute(query);

    }


}

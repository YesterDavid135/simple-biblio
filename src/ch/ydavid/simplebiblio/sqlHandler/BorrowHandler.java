package ch.ydavid.simplebiblio.sqlHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BorrowHandler extends SqlHandler {

    public boolean borrowItem(int itemID, int userID) {
        try {
            String query = "INSERT INTO tbl_borrowed (fk_idUser, fk_idItem) ";
            query += "VALUES (" + userID + ", " + itemID + ")";

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            stmt.execute(query);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean returnItem(int itemID) {
        try {
            String query = "UPDATE tbl_borrowed SET returned = 1 where returned = 0 AND fk_idItem = ";
            query += itemID;

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            return stmt.execute(query);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<Integer> getBorrowedItems(int userID) {
        try {
            String query = "SELECT fk_idItem FROM tbl_borrowed where returned = 0";
            if (userID != -1)
                query += " and fk_idUser = " + userID;

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Integer> returnSet = new ArrayList<>();

            while (rs.next())
                returnSet.add(rs.getInt("fk_idItem"));
            return returnSet;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
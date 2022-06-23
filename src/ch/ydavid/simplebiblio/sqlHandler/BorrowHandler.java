package ch.ydavid.simplebiblio.sqlHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BorrowHandler extends SqlHandler {
    /**
     * Borrows a Item
     *
     * @param itemID item to be borrowed
     * @param userID user who borrowes the item
     * @return boolean true if successful
     */
    public boolean borrowItem(int itemID, int userID) {
        try {
            String query = "INSERT INTO tbl_borrowed (\"fk_idUser\", \"fk_idItem\") ";
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

    /**
     * Return a borrowed item
     *
     * @param itemID item to be returned
     * @return boolean true if successful
     */
    public boolean returnItem(int itemID) {
        try {
            String query = "UPDATE tbl_borrowed SET returned = 1 where returned = 0 AND \"fk_idItem\" = ";
            query += itemID;

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            stmt.execute(query);

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Get all Borrowed items
     *
     * @param userID borrowed user or -1 for all
     * @return ArrayList of borrowed items
     */
    public ArrayList<Integer> getBorrowedItems(int userID) {
        try {
            String query = "SELECT \"fk_idItem\" FROM tbl_borrowed WHERE returned = 0";
            if (userID != -1)
                query += " and \"fk_idUser\" = " + userID;

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

    /**
     * Get all Items which are returned
     *
     * @return ArrayList of Item ID
     */
    public ArrayList<Integer> getReturnedItems() {
        try {
            String query = "SELECT \"fk_idItem\" FROM tbl_borrowed WHERE returned = 1 GROUP BY \"fk_idItem\"";

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

    public boolean deleteEntries(int userID) {

        try {
            String query = "DELETE FROM tbl_borrowed ";

            if (userID != -1){
                query+="where \"fk_idUser\" = " + userID;
            }

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            stmt.execute(query);

            if (!stmt.execute(query)){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        return false;
    }
}
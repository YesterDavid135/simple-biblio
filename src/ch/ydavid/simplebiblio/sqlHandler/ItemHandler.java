package ch.ydavid.simplebiblio.sqlHandler;

import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.dto.MediaType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemHandler extends SqlHandler {

    /**
     * Creates a new Item
     *
     * @param i item to be created
     */
    public boolean addItem(Item i) {

        try {
            String query = "insert into tbl_items (title, \"ageRating\", autor, shelf, \"ISBN\", \"fk_mediaType\") " +
                    "values ('" + i.getTitel() + "'," + i.getAgeRating() + ",'" + i.getAutor() + "',"
                    + i.getShelf() + "," + i.getIsbn() + "," + (i.getMediaType().ordinal()+1) + ")";

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            if (!stmt.execute(query)){
                int count = stmt.getUpdateCount();
                return count == 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Get all Items in database
     *
     * @return ArrayList of Items
     */
    public ArrayList<Item> getItems() {
        try {
            String query = "SELECT * FROM tbl_items";

            Connection connection = super.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Item> returnSet = new ArrayList<>();

            while (rs.next()) {
                Item tmpItem = new Item(
                        rs.getInt("idMedia"),
                        rs.getString("title"),
                        MediaType.Book.getValue(rs.getInt("fk_mediaType")),  //Maybe Error lol #todo
                        rs.getInt("ageRating"),
                        rs.getString("autor"),
                        rs.getInt("isbn"),
                        rs.getInt("shelf"));
                returnSet.add(tmpItem);
            }

            return returnSet;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

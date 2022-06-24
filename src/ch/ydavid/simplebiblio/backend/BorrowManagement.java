package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Borrowed;
import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.sqlHandler.BorrowHandler;
import ch.ydavid.simplebiblio.sqlHandler.ItemHandler;

import java.util.ArrayList;

public class BorrowManagement implements BorrowInterface {

    BorrowHandler sqlHandler = new BorrowHandler();

    /**
     * Borrow a item
     *
     * @param itemID item to be borrowed
     * @param userID user who borrow the item
     * @return boolean indicating success
     */
    public boolean borrowItem(int itemID, int userID) {
        if (!sqlHandler.getBorrowedItems(userID).contains(itemID)) {
            return sqlHandler.borrowItem(itemID, userID);
        } else {
            return false;
        }
    }

    /**
     * Return a item to the biblio
     *
     * @param itemID item to be returned
     * @return boolean indicating success
     */
    public boolean returnItem(int itemID) {
        if (sqlHandler.getBorrowedItems(-1).contains(itemID)) {
            return sqlHandler.returnItem(itemID);
        } else {
            return false;
        }
    }

    /**
     * Get Available Items to borrow
     *
     * @return ArrayList containing available items
     */
    public ArrayList<Item> getAvalibleItems() {

        ArrayList<Integer> borrowedItems = sqlHandler.getBorrowedItems(-1);

        ArrayList<Item> returnArray = new ArrayList<>();

        for (Item i : new ItemHandler().getItems()) {
            if (!borrowedItems.contains(i.getID())) {
                returnArray.add(i);
            }
        }

        return returnArray;
    }

    /**
     * Get all Borrowed Items
     *
     * @param userID borrowed user or -1 for all
     * @return ArrayList containing all Items
     */
    public ArrayList<Item> getBorrowedItems(int userID) {

        ArrayList<Integer> borrowedItems = sqlHandler.getBorrowedItems(userID);

        ArrayList<Item> returnArray = new ArrayList<>();

        for (Item i : new ItemHandler().getItems()) {
            if (borrowedItems.contains(i.getID())) {
                returnArray.add(i);
            }
        }

        return returnArray;
    }

    public boolean deleteEntries(String username) {
        int userID = -1;

        if (username != null)
            userID = new UserManagement().searchUser(username).getIdUser();


        return sqlHandler.deleteEntries(userID);


    }

    public ArrayList<Borrowed> getUnreturnedEntries() {

        return sqlHandler.getUnreturnedItems();


    }
}

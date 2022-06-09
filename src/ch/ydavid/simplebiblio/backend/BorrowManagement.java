package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.sqlHandler.BorrowHandler;
import ch.ydavid.simplebiblio.sqlHandler.ItemHandler;

import java.util.ArrayList;

public class BorrowManagement implements BorrowInterface {

    BorrowHandler sqlHandler = new BorrowHandler();

    public boolean borrowItem(int itemID, int userID) {
        if (!sqlHandler.getBorrowedItems(userID).contains(itemID)) {
            return sqlHandler.borrowItem(itemID, userID);
        } else {
            return false;
        }
    }


    public boolean returnItem(int itemID) {
        if (sqlHandler.getBorrowedItems(-1).contains(itemID)) {
            return sqlHandler.returnItem(itemID);
        } else {
            return false;
        }
    }

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
}

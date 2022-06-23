package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.sqlHandler.ItemHandler;

import java.util.ArrayList;

public class ItemManagement implements ItemInterface {

    ItemHandler sqlHandler = new ItemHandler();

    /**
     * Search for Item in the Database
     *
     * @return
     */
    public ArrayList<Item> searchItem(String s) {


        ArrayList<Item> returnArray = new ArrayList<>();

        for (Item i : sqlHandler.getItems()){
            if (i.getTitel().matches(".*" + s + ".*"))
                returnArray.add(i);
        }

        return returnArray;
    }

    /**
     * Add a Item to the Database
     *
     * @return
     */
    public boolean addItem(Item newItem) {

       return sqlHandler.addItem(newItem);

    }
}

package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.sqlHandler.ItemHandler;

public class ItemManagement implements ItemInterface {

    ItemHandler sqlHandler = new ItemHandler();

    /**
     * Search for Item in the Database
     */
    public void searchItem() {

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

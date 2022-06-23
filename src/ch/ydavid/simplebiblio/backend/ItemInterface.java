package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;

public interface ItemInterface {

    public void searchItem();
    public boolean addItem(Item newItem);
}

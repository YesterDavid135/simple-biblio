package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;

import java.util.ArrayList;

public interface ItemInterface {

    public ArrayList<Item> searchItem(String s);
    public boolean addItem(Item newItem);
}

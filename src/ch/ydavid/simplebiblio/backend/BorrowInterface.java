package ch.ydavid.simplebiblio.backend;

import ch.ydavid.simplebiblio.dto.Item;

import java.util.ArrayList;

public interface BorrowInterface {
    public boolean borrowItem(int userID, int itemID);

    public boolean returnItem(int itemID);

    public ArrayList<Item> getAvalibleItems();
}

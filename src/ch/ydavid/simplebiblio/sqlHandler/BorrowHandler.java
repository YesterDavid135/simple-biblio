package ch.ydavid.simplebiblio.sqlHandler;

import ch.ydavid.simplebiblio.dto.Item;

import java.util.ArrayList;

public class BorrowHandler extends SqlHandler {

    public boolean borrowItem(int userID, int itemID){
        return false;
    }

    public void returnItem(int itemID){
    }

    public ArrayList<Item> getAvailableItems(){

            return new ArrayList<>();
            }

}
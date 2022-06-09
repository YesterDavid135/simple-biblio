package ch.ydavid.simplebiblio.backend;

public class BorrowManagement implements BorrowInterface {

    public void borrowItem() {

    }


    public void returnItem(int itemID) {
        sqlHandler.returnItem(itemID);
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
}

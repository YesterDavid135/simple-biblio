package dto;

import java.sql.Timestamp;

public class Borrowed {

    private int idBorrow;
    private User user;
    private Inventory item;
    private Timestamp timestamp;
    private boolean isReturned;

    public Borrowed(int idBorrow, User user, Inventory item, Timestamp timestamp, boolean isReturned) {
        this.idBorrow = idBorrow;
        this.user = user;
        this.item = item;
        this.timestamp = timestamp;
        this.isReturned = isReturned;
    }

    public int getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        this.idBorrow = idBorrow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Inventory getItem() {
        return item;
    }

    public void setItem(Inventory item) {
        this.item = item;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}

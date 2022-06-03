package ch.ydavid.simplebiblio.backend;

public interface Backend {
    public BorrowManagement getBorrowManager();
    public ItemManagement getItemManager();
    public UserManagement getUserManager();
}

package ch.ydavid.simplebiblio.backend;

public class BackendFacade implements Backend{

    private BorrowManagement borrowManager;
    private ItemManagement itemManager;
    private UserManagement userManager;

    public BorrowManagement getBorrowManager() {
        if (borrowManager == null)
            borrowManager = new BorrowManagement();
        return borrowManager;
    }

    public ItemManagement getItemManager() {
        if (itemManager == null)
            itemManager = new ItemManagement();
        return itemManager;
    }

    public UserManagement getUserManager() {
        if (userManager == null)
            userManager = new UserManagement();
        return userManager;
    }
}

package frontend;

public class View {

    public View(int usergroup) {
        if (usergroup == 0) {
            printCustomerMenu();
        } else {
            printEmployeeMenu();
        }
    }

    public void printCustomerMenu() {
        System.out.println("*** WELCOME TO SIMPLEBIBLIO ***");
        System.out.println("Type 1 to borrow an item.");
        System.out.println("Type 2 to return an item.");
        System.out.println("Type 3 to exit the Simple-Biblio.");
    }

    private void printEmployeeMenu() {
        System.out.println("*** WELCOME TO SIMPLE-BIBLIO ***");
        System.out.println("Type 1 to borrow an item.");
        System.out.println("Type 2 to return an item.");
        System.out.println("Type 3 to exit the Simple-Biblio.");
        System.out.println("*** Employee Options ***");
        System.out.println("Type 4 to add a customer.");
        System.out.println("Type 5 to search for a customer.");
        System.out.println("Type 6 to change the address of a customer.");
        System.out.println("Type 7 to add an item.");
        System.out.println("Type 8 to search for an item.");
    }
}

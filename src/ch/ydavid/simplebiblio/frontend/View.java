package ch.ydavid.simplebiblio.frontend;

import ch.ydavid.simplebiblio.backend.BackendFacade;
import ch.ydavid.simplebiblio.dto.Item;

import java.util.Scanner;

public class View {
    private int userID;
    private BackendFacade backend;

    public View(int userID) {
        this.userID = userID;
        this.backend = new BackendFacade();
        printMenu();
    }

    public void addCustomer() {

    }

    public void addItem() {

    }

    public void borrowItem() {

    }

    public void changeCustomer() {

    }

    public void getAvalibleItems() {

    }

    public void printMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** WELCOME TO SIMPLEBIBLIO ***");
        System.out.println("You're userID is: " + userID);
        System.out.println("Type 1 to borrow an item.");
        System.out.println("Type 2 to return an item.");
        System.out.println("Type 3 to exit the Simple-Biblio.");

        int input = sc.nextInt();
        int itemID;

        switch (input) {
            case 1:
                borrowItem();
                break;
            case 2:
                System.out.print("Please provide the Item ID:");
                itemID = sc.nextInt();
                returnItem(itemID);
                break;
            case 3:
                System.exit(69);
                break;
            default:
                System.out.println("Invalid input. Please try again");
        }

    }

    public void returnItem() {

    }

    public void searchCustomer() {

    }

    public void searchItem() {

    }
}

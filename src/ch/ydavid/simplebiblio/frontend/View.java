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
        System.out.format("%5s%40s%30s%20s", "ID", "Titel", "Autor", "Mediatype");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Item i : backend.getBorrowManager().getAvalibleItems()) {
            System.out.format("%5d%40s%30s%20s", i.getID(), i.getTitel(), i.getAutor(), i.getMediaType());
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Select your item (-1 for exit): ");

        int input = sc.nextInt();

        if (backend.getBorrowManager().borrowItem(input, userID)) {
            System.out.println("Succesfully borrowed the Item");
        } else {
            System.out.println("Error.");
            System.exit(12);
        }

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

    public void returnItem(int itemID) {
        backend.getBorrowManager().returnItem(itemID);
    }

    public void searchCustomer() {

    }

    public void searchItem() {

    }
}

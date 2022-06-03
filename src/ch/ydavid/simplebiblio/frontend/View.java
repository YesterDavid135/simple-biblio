package ch.ydavid.simplebiblio.frontend;

import ch.ydavid.simplebiblio.backend.BackendFacade;

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
        System.out.println("Type 1 to borrow an item.");
        System.out.println("Type 2 to return an item.");
        System.out.println("Type 3 to exit the Simple-Biblio.");

        int input = sc.nextInt();
    }

    public void returnItem() {

    }

    public void searchCustomer() {

    }

    public void searchItem() {

    }
}

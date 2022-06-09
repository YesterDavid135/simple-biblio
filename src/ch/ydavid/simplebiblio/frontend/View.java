package ch.ydavid.simplebiblio.frontend;

import ch.ydavid.simplebiblio.backend.BackendFacade;
import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.dto.User;

import java.util.Scanner;

public class View {
    private User user;
    private BackendFacade backend;

    public View() {
        this.backend = new BackendFacade();
        login();
        printMenu();
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        String username = sc.nextLine();

        System.out.print("Please enter your password: ");
        String password = sc.nextLine();

        User user = backend.getUserManager().checkLogin(username, password);

        if (user == null) {
            System.out.println("Username or password is wrong");
            System.out.println("bye");
            System.exit(1);
        }

        this.user = user;

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

        if (backend.getBorrowManager().borrowItem(input, user.getIdUser())) {
            System.out.println("Succesfully borrowed the Item");
        } else {
            System.out.println("Error.");
        }

    }

    public void changeCustomer() {

    }

    public void getAvalibleItems() {

    }

    public void printMenu() {
        System.out.println("*** WELCOME TO SIMPLEBIBLIO, " + user.getVname() + " ***");

        Scanner sc = new Scanner(System.in);

        while (true) {
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
                    returnItem();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
            System.out.println();
        }
    }

    public void returnItem() {
        System.out.format("%5s%40s%30s%20s%20s", "ID", "Titel", "Autor", "Mediatype", "User");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        for (Item i : backend.getBorrowManager().getBorrowedItems(-1)) {
            System.out.format("%5d%40s%30s%20s%20s", i.getID(), i.getTitel(), i.getAutor(), i.getMediaType(), "you're mama");
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Select your item (-1 for exit): ");

        int input = sc.nextInt();

        if (backend.getBorrowManager().returnItem(input)) {
            System.out.println("Succesfully returned the Item");
        } else {
            System.out.println("Error.");
        }
    }

    public void searchCustomer() {

    }

    public void searchItem() {

    }
}

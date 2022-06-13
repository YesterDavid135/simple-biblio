package ch.ydavid.simplebiblio.frontend;

import ch.ydavid.simplebiblio.backend.BackendFacade;
import ch.ydavid.simplebiblio.dto.Item;
import ch.ydavid.simplebiblio.dto.Location;
import ch.ydavid.simplebiblio.dto.User;

import java.util.Scanner;

public class View {
    private User user; //Current logged in user
    private BackendFacade backend;

    private final Scanner sc;

    /**
     * Constructor / Entry Point
     **/
    public View() {
        sc = new Scanner(System.in);


        this.backend = new BackendFacade();
        System.out.println("Press 1 to Register");
        System.out.println("Press 2 to Login");
        System.out.println("Press 3 to Exit");

        int input = sc.nextInt();
        sc.nextLine();

        switch (input) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            default:
                System.exit(0);
        }

        printMenu();
    }

    private void register() {
        System.out.println("Hello newbie");
        System.out.println("Please enter your worthy data:");

        User newbie = new User();

        System.out.print("First Name: ");
        newbie.setVname(sc.nextLine());

        System.out.print("Last Name: ");
        newbie.setName(sc.nextLine());

        while (true) {
            System.out.print("Username: ");
            newbie.setUsername(sc.nextLine());

            if (backend.getUserManager().checkUsername(newbie.getUsername())) {
                break;
            }

            System.out.println("Username already taken, please try again.");

        }


        System.out.print("Email: ");
        newbie.setMail(sc.nextLine());

        System.out.print("Year of Birth: ");
        newbie.setYob(sc.nextInt());
        sc.nextLine();

        System.out.print("Street: ");
        newbie.setStreet(sc.nextLine());

        System.out.print("ZIP: ");
        Location location = new Location();
        location.setZIP(sc.nextLine());

        System.out.print("Location: ");
        location.setLocation(sc.nextLine());
        newbie.setLocation(location);

        System.out.println("Create password: ");
        String password = sc.nextLine();

        System.out.println("Confirm password: ");
        if (!password.equals(sc.nextLine())) {
            System.out.println("Passwords don't match");
            System.exit(0);
        }

        newbie.setPassword(password.hashCode());

    }

    /**
     * Logging in User
     **/
    private void login() {
        System.out.print("Please enter your username: ");
        String username = sc.nextLine();

        System.out.print("Please enter your password: ");
        String password = sc.nextLine();

        User user = backend.getUserManager().checkLogin(username, password);

        if (user == null) {
            System.out.println("Username or password is wrong.");
            System.out.println("Bye.");
            System.exit(1);
        }

        this.user = user;

    }

    /**
     * Add a User
     */
    public void addCustomer() {

    }

    /**
     * Add a Item
     */
    public void addItem() {

    }

    /**
     * Borrows a Itme
     */
    public void borrowItem() {
        getAvalibleItems();

        System.out.print("Select your item (-1 for exit): ");
        int input = sc.nextInt();

        if (input == -1) {
            System.out.println("Exiting...");
        } else if (backend.getBorrowManager().borrowItem(input, user.getIdUser())) {
            System.out.println("Successfully borrowed the item.");
        } else {
            System.out.println("ERROR");
        }

    }

    /**
     * Edits a User
     */
    public void changeCustomer() {

    }

    /**
     * Show Available Items
     */
    public void getAvalibleItems() {
        System.out.format("%5s%40s%30s%20s", "ID", "Titel", "Autor", "Mediatype");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Item i : backend.getBorrowManager().getAvalibleItems()) {
            System.out.format("%5d%40s%30s%20s", i.getID(), i.getTitel(), i.getAutor(), i.getMediaType());
            System.out.println();
        }
    }

    /**
     * Prints main Menu
     */
    public void printMenu() {
        System.out.println();
        System.out.println("*** Welcome To SIMPLEBIBLIO, " + user.getVname() + " ***");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Type 1 to borrow an item.");
            System.out.println("Type 2 to return an item.");
            System.out.println("Type 3 to exit the Simple-Biblio.");

            int input = sc.nextInt();

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

    /**
     * Return a borrowed item
     */
    public void returnItem() {
        System.out.format("%5s%40s%30s%20s", "ID", "Titel", "Autor", "Mediatype");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Item i : backend.getBorrowManager().getBorrowedItems(-1)) {
            System.out.format("%5d%40s%30s%20s", i.getID(), i.getTitel(), i.getAutor(), i.getMediaType());
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Select your item (-1 for exit): ");

        int input = sc.nextInt();

        if (input == -1) {
            System.out.println("Exiting...");
        } else if (backend.getBorrowManager().returnItem(input)) {
            System.out.println("Successfully returned the item.");
        } else {
            System.out.println("ERROR");
        }
    }

    /**
     * Search for a Customer
     */
    public void searchCustomer() {

    }

    /**
     * Search for a Item
     */
    public void searchItem() {

    }
}

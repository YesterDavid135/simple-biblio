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

        user = backend.getUserManager().addUser(newbie);

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
    private void addCustomer() {

    }

    /**
     * Add a Item
     */
    private void addItem() {
        sc.nextLine();
        System.out.println("Please provide us with some information about the new Item.");
        Item newItem = new Item();
        System.out.print("Title: ");
        newItem.setTitel(sc.nextLine());
        System.out.print("Author: ");
        newItem.setAutor(sc.nextLine());
        System.out.print("AgeRating: ");
        newItem.setAgeRating(sc.nextInt());
        System.out.println("Mediatype: ");
        System.out.println("1: Book");
        System.out.println("2: DVD");
        System.out.println("3: Audio-CD");
        System.out.println("4: Computer-Game");
        System.out.print("Input: ");
        newItem.setMediaType(sc.nextInt());
        System.out.print("ISBN: ");
        newItem.setIsbn(sc.nextInt());
        System.out.print("Shelf (int): ");
        newItem.setShelf(sc.nextInt());
        sc.nextLine();

        if (backend.getItemManager().addItem(newItem)) {
            System.out.println("Success!");
        } else {
            System.out.println("Error.");
        }
    }

    /**
     * Borrows a Itme
     */
    private void borrowItem() {
        getAvalibleItems();

        System.out.print("Select your item (-1 for exit): ");
        int input = sc.nextInt();

        if (input == -1) {
            System.out.println("Exiting...");
        } else if (backend.getBorrowManager().borrowItem(input, user.getIdUser())) {
            System.out.println("Successfully borrowed the item.");
        } else {
            System.out.println("Error.");
        }

    }

    /**
     * Edits a User
     */
    private void changeCustomer() {

    }

    /**
     * Show Available Items
     */
    private void getAvalibleItems() {
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
    private void printMenu() {
        if (user.getIdUser() == 0) {
            System.out.println("Welcome, Admin! ");

            while (true) {

                System.out.println("Type 1 for Item Management");
                System.out.println("Type 2 for User Management");
                System.out.println("Type 3 for Borrow Management");
                System.out.println("Type 4 to exit");

                switch (sc.nextInt()) {
                    case 1 -> {
                        System.out.println("Type 1 to search for a item");
                        System.out.println("Type 2 to add an Item");
                        System.out.println("Type 3 to remove an Item");
                        switch (sc.nextInt()) {
                            case 1 -> searchItem();
                            case 2 -> addItem();
                            case 3 -> removeItem();

                            default -> {
                                System.out.println("Invalid Input!");
                                System.out.println("Please try Again");
                            }
                        }

                    }
                    case 2 -> {
                        System.out.println("Type 1 to search for Users");
                        System.out.println("Type 2 to remove an User");
                        System.out.println("Type 3 to change password for a User");
                        switch (sc.nextInt()) {
                            case 1 -> searchCustomer();
                            case 2 -> removeCustomer();
                            case 3 -> changePassword();
                            default -> {
                                System.out.println("Invalid Input!");
                                System.out.println("Please try Again");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Type 1 to delete ALL Borrow Entries");
                        System.out.println("Type 2 to delete entries for a user");

                        switch (sc.nextInt()){
                            case 1 -> deleteBorrowEntries();
                            case 2 -> deleteBorrowEntry();
                        }

                    }
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid input. Please try again");
                }

            }
        }
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

    private void changePassword() {
        //todo
    }

    private void deleteBorrowEntries() {
        sc.nextLine();
        System.out.println("Are you sure to delete ALL Borrow Entries?");
        System.out.print("Type YES to Continue: ");

        if (!sc.nextLine().toLowerCase().equals("yes")){
            System.out.println("Process Aborted!");
            return;
        }

      if(backend.getBorrowManager().deleteEntries(null))
          System.out.println("Succesfully deleted all Entries");
    else
        System.out.println("Error occured, please ask Noel");

    }

    private void deleteBorrowEntry() {
        sc.nextLine();
        System.out.println("You are about to delete all Borrow Entries for one User");
        System.out.print("Please enter username or -1 for exit: ");

        String username = sc.nextLine();
        if (username.equals("-1")){
            return;
        }

        if(backend.getBorrowManager().deleteEntries(username))
            System.out.println("Succesfully deleted all Entries for " + username);
        else
            System.out.println("Error occured, please ask Noel");



    }

    private void removeCustomer() {
        System.out.println("Please type in the username of the customer: ");
        String input = sc.next();

        if (backend.getUserManager().searchUser(input) == null) {
            System.out.println("Error: User not found.");
            return;
        }

        if (!backend.getUserManager().removeUser(input)) {
            System.out.println("Error.");
            return;
        }

        System.out.println("Successfully removed User.");
    }

    /**
     * Removes a Item from the Database
     */
    private void removeItem() {

        searchItem();

        System.out.println("Please enter ID to delete");

       if(backend.getItemManager().deleteItem(sc.nextInt()))
           System.out.println("Succesfully deleted the Item");
       else
           System.out.println("Error occured, please ask Noel");

    }

    /**
     * Return a borrowed item
     */
    private void returnItem() {
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
            System.out.println("Error.");
        }
    }

    /**
     * Search for a Customer
     */
    private void searchCustomer() {
        System.out.println("Please type in the username of the customer: ");
        String input = sc.next();

        if (backend.getUserManager().searchUser(input) == null) {
            System.out.println("Error: User not found.");
            return;
        }

        User user = backend.getUserManager().searchUser(input);

        System.out.println("--- USER FOUND ---");
        System.out.println("ID: " + user.getIdUser());
        System.out.println("Username: " + user.getUsername());
        System.out.println("First Name: " + user.getVname());
        System.out.println("Last Name: " + user.getName());
        System.out.println("Year of Birth: " + user.getYob());
        System.out.println("Street: " + user.getStreet());
        System.out.println("Location: " + user.getLocation().getZIP() + " " +  user.getLocation().getLocation());
        System.out.println("Email: " + user.getMail());
        System.out.println("------------------");
    }

    /**
     * Search for a Item
     */
    private void searchItem() {
        sc.nextLine();
        System.out.print("Please enter Title of the Item: ");
        String itemTitle = sc.nextLine();
        System.out.println();
        System.out.format("%5s%40s%30s%20s", "ID", "Titel", "Autor", "Mediatype");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Item i : backend.getItemManager().searchItem((itemTitle))) {
            System.out.format("%5d%40s%30s%20s", i.getID(), i.getTitel(), i.getAutor(), i.getMediaType());
            System.out.println();
        }

    }
}

package frontend;

import java.util.Scanner;

public class View {
    private final int userID;

    public View(int userID) {
        this.userID = userID;
        printMenu();
    }

    public void printMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** WELCOME TO SIMPLEBIBLIO ***");
        System.out.println("Type 1 to borrow an item.");
        System.out.println("Type 2 to return an item.");
        System.out.println("Type 3 to exit the Simple-Biblio.");

        int input = sc.nextInt();
    }
}

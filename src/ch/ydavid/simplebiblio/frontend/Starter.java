package ch.ydavid.simplebiblio.frontend;

public class Starter {
    public static void main(String[] args) {
        try {
            int userID = Integer.parseInt(args[0]);
            new View(userID);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

import frontend.View;

public class Main {
    public static void main(String[] args) {
        try {
            int userID = Integer.parseInt(args[0]);
            new View(userID);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
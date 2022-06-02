import frontend.View;

public class Main {
    public static void main(String[] args) {
        try {
            int usergroup = Integer.parseInt(args[0]);
            if (usergroup == 0 || usergroup == 1) {
                new View(usergroup);
            } else {
                System.out.println("Invalid usergroup. Choose between 0 (Customer) and 1 (Employee).");
            }
        } catch (Exception e) {
            System.out.println("Invalid usergroup. Choose between 0 (Customer) and 1 (Employee).");
        }
    }
}
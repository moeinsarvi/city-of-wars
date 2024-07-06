import controller.UserController;
import model.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        MainMenu mainMenu = new MainMenu();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            mainMenu.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    // Start Game logic
                    break;
                case 2:
                    // View Cards logic
                    break;
                case 3:
                    // View Battle History logic
                    break;
                case 4:
                    // Store logic
                    break;
                case 5:
                    // Profile logic
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}

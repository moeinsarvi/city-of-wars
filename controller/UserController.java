package controller;

import model.Admin;
import model.Card;
import model.User;
import model.SecurityQuestion;
import utils.FileManager;

import java.util.Random;
import java.util.Scanner;

public class UserController {

    private Admin admin = new Admin();

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (User.usernameExists(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.println("Enter password (or type 'random' for a random password):");
        String password = scanner.nextLine();
        String confirmPassword = null;

        if ("random".equalsIgnoreCase(password)) {
            password = generateRandomPassword();
            System.out.println("Your random password: " + password);
        } else {
            System.out.println("Confirm password:");
            confirmPassword = scanner.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match!");
                return;
            }
        }

        System.out.println("Enter nickname:");
        String nickname = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Choose a security question:");
        for (SecurityQuestion question : SecurityQuestion.values()) {
            System.out.println(question.ordinal() + 1 + ". " + question.getQuestion());
        }
        int questionChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        SecurityQuestion securityQuestion = SecurityQuestion.values()[questionChoice - 1];

        System.out.println("Answer the security question:");
        String securityAnswer = scanner.nextLine();

        User user = new User(username, password, nickname, email, securityQuestion, securityAnswer);
        User.addUser(user);

        FileManager.saveUser(user);

        System.out.println("User created successfully.");
    }

    private String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    public void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        User user = User.getUser(username);
        if (user == null) {
            System.out.println("Username doesn't exist!");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (user.getPassword().equals(password)) {
            System.out.println("User logged in successfully!");
            user.setFailedLoginAttempts(0);
        } else {
            user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
            System.out.println("Password and Username don’t match! Try again in " + 5 * user.getFailedLoginAttempts() + " seconds.");
        }
    }

    public void adminOperations() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Card");
            System.out.println("2. Edit Card");
            System.out.println("3. Delete Card");
            System.out.println("4. View All Players");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter card details (name attack defense duration playerDamage upgradeLevel upgradeCost):");
                    String cardDetails = scanner.nextLine();
                    String[] parts = cardDetails.split(" ");
                    Card newCard = new Card(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]));
                    admin.addCard(newCard);
                    break;
                case 2:
                    System.out.println("Enter card details (name attack defense duration playerDamage upgradeLevel upgradeCost):");
                    String editDetails = scanner.nextLine();
                    String[] editParts = editDetails.split(" ");
                    Card editCard = new Card(editParts[0], Integer.parseInt(editParts[1]), Integer.parseInt(editParts[2]),
                            Integer.parseInt(editParts[3]), Integer.parseInt(editParts[4]), Integer.parseInt(editParts[5]),
                            Integer.parseInt(editParts[6]));
                    admin.editCard(editCard);
                    break;
                case 3:
                    System.out.println("Enter card name to delete:");
                    String cardName = scanner.nextLine();
                    admin.deleteCard(cardName);
                    break;
                case 4:
                    admin.viewAllPlayers().forEach(player -> {
                        System.out.println("Player: " + player.getUsername() + ", Level: " + player.getLevel());
                    });
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}

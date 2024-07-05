package model;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;
    private int failedLoginAttempts;
    private static HashMap<String, User> users = new HashMap<>();

    public User(String username, String password, String nickname, String email, SecurityQuestion securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.failedLoginAttempts = 0;
    }

    // Getters and Setters

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static User getUser(String username) {
        return users.get(username);
    }

    public static boolean usernameExists(String username) {
        return users.containsKey(username);
    }
}

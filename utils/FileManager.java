package utils;

import model.User;
import java.io.*;
import java.util.HashMap;

public class FileManager {
    private static final String FILE_PATH = "users.dat";

    public static void saveUser(User user) {
        HashMap<String, User> users = loadUsers();
        users.put(user.getUsername(), user);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (HashMap<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}

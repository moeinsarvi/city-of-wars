package utils;

import model.User;
import model.Card;
import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileManager {
    private static final String USER_FILE_PATH = "users.dat";
    private static final String CARD_FILE_PATH = "cards.dat";
    private static final String PLAYER_FILE_PATH = "players.dat";

    // Save all users to file
    public static void saveUsers(HashMap<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all users from file
    public static HashMap<String, User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            return (HashMap<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    // Save all cards to file
    public static void saveCards(List<Card> cards) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARD_FILE_PATH))) {
            oos.writeObject(cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all cards from file
    public static List<Card> loadCards() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARD_FILE_PATH))) {
            return (List<Card>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save all players to file
    public static void savePlayers(List<Player> players) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PLAYER_FILE_PATH))) {
            oos.writeObject(players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all players from file
    public static List<Player> loadPlayers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PLAYER_FILE_PATH))) {
            return (List<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

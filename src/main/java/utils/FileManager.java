package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.Card;
import model.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FileManager {
    private static final String USER_FILE_PATH = "users.json";
    private static final String CARD_FILE_PATH = "cards.json";
    private static final String PLAYER_FILE_PATH = "players.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Save all users to JSON file
    public static void saveUsers(HashMap<String, User> users) {
        try {
            objectMapper.writeValue(new File(USER_FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all users from JSON file
    public static HashMap<String, User> loadUsers() {
        try {
            return objectMapper.readValue(new File(USER_FILE_PATH), new TypeReference<HashMap<String, User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    // Save all cards to JSON file
    public static void saveCards(List<Card> cards) {
        try {
            objectMapper.writeValue(new File(CARD_FILE_PATH), cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all cards from JSON file
    public static List<Card> loadCards() {
        try {
            return objectMapper.readValue(new File(CARD_FILE_PATH), new TypeReference<List<Card>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save all players to JSON file
    public static void savePlayers(List<Player> players) {
        try {
            objectMapper.writeValue(new File(PLAYER_FILE_PATH), players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all players from JSON file
    public static List<Player> loadPlayers() {
        try {
            return objectMapper.readValue(new File(PLAYER_FILE_PATH), new TypeReference<List<Player>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

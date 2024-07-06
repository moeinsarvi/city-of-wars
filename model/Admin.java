package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {
    private static Map<String, Card> cards = new HashMap<>();
    private static List<Player> players = new ArrayList<>();

    public void addCard(Card card) {
        if (cards.containsKey(card.getName())) {
            System.out.println("Card with this name already exists!");
        } else {
            cards.put(card.getName(), card);
            System.out.println("Card added successfully.");
        }
    }

    public void editCard(Card card) {
        if (cards.containsKey(card.getName())) {
            cards.put(card.getName(), card);
            System.out.println("Card edited successfully.");
        } else {
            System.out.println("Card not found!");
        }
    }

    public void deleteCard(String cardName) {
        if (cards.containsKey(cardName)) {
            cards.remove(cardName);
            System.out.println("Card deleted successfully.");
        } else {
            System.out.println("Card not found!");
        }
    }

    public List<Player> viewAllPlayers() {
        return new ArrayList<>(players);
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void addInitialCards() {
        // Method to add some initial cards for testing purposes
        cards.put("Fireball", new Card("Fireball", 5, 2, 1, 10, 1, 100));
        cards.put("Shield", new Card("Shield", 2, 5, 2, 0, 1, 100));
    }
}

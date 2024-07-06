package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String username;
    private int level;
    private int hp;
    private int xp;
    private int coins;
    private List<Card> cards;

    public Player(String username) {
        this.username = username;
        this.level = 1;
        this.hp = 100;
        this.xp = 0;
        this.coins = 0;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }
    // Other getters and setters
}

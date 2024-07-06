package model;

public class Card {
    private String name;
    private int attack;
    private int defense;
    private int duration;
    private int playerDamage;
    private int upgradeLevel;
    private int upgradeCost;

    public Card(String name, int attack, int defense, int duration, int playerDamage, int upgradeLevel, int upgradeCost) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.duration = duration;
        this.playerDamage = playerDamage;
        this.upgradeLevel = upgradeLevel;
        this.upgradeCost = upgradeCost;
    }

    public String getName() {
        return name;
    }

    // Getters and Setters
}

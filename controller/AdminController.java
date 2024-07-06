package controller;

import model.Admin;
import model.Card;

public class AdminController {
    private Admin admin;

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    public void addCard(Card card) {
        admin.addCard(card);
    }

    public void editCard(Card card) {
        admin.editCard(card);
    }

    public void deleteCard(String cardName) {
        admin.deleteCard(cardName);
    }

    public void viewAllPlayers() {
        admin.viewAllPlayers().forEach(player -> {
            System.out.println("Player: " + player.getUsername() + ", Level: " + player.getLevel());
        });
    }
}

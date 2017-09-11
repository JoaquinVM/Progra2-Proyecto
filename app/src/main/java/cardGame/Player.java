package cardGame;


import java.util.LinkedList;
import java.util.List;

import cardGame.cards.Card;
import cardGame.cards.Deck;
import cardGame.cards.Meme;
import cardGame.utils.Constants;
import cardGame.utils.Enums;

/**
 * Created by Rodrigo on 5/9/2017.
 */


public abstract class Player implements cardGame.Damagable {
    private String powerImage;
    private String name = "";
    private int maxHealth = Constants.MAX_PLAYER_HEALTH;
    private int health = Constants.MAX_PLAYER_HEALTH;
    private int mana = 0;
    private Deck deck;
    private Game game;
    private List<Card> hand = new LinkedList<>();
    private List<Meme> arena = new LinkedList<>();
    private List<Meme> graveyard = new LinkedList<>();

    private boolean dead = false;


    public int getHealth() {
        return health;
    }

    public abstract void power(Meme meme);

    public void setPowerImage(String powerImage) {
        this.powerImage = powerImage;
    }

    public String getPowerImage() {
        return powerImage;
    }

    @Override
    public void damage(int damage) {
        health -= damage;
        if (health <= 0) {
            dead = true;
        }
    }

    @Override
    public void heal(int health) {
        this.health += health;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public void drawCard() {
        hand.add(deck.drawCard());
    }

    public void summon(Meme meme) {
        arena.add(meme);
    }

    public Game getGame() {
        return game;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Meme> getArena() {
        return arena;
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Meme> getGraveyard() {
        return graveyard;
    }

    public int getMana() {
        return mana;
    }

    public void increaseMana() {
        mana++;
        if (mana > 7) {
            mana = 7;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String image() {
        return getName() + "_" + health;
    }
}

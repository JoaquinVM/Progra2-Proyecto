package cardGame;


import cardGame.cards.Deck;
import cardGame.cards.Meme;
import cardGame.utils.Constants;

/**
 * Created by Rodrigo on 5/9/2017.
 */


public abstract class Player implements Damagable {
    private int health;
    private int maxHealth = Constants.MAX_PLAYER_HEALTH;
    private Deck deck;
    private Game game;

    private boolean dead = false;

    public Player(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public abstract void power(Meme meme);

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
        if(this.health > maxHealth){
            this.health = maxHealth;
        }
    }

    public Game getGame() {
        return game;
    }

    private void setDeck(Deck deck) {
        this.deck = deck;
    }

}

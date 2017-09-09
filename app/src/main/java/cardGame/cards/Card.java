package cardGame.cards;

import cardGame.Damagable;
import cardGame.Game;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Card {
    private int cost;
    private String name;
    private Game game;

    public Card(String name, int cost, Game game) {
        this.name = name;
        this.cost = cost;
        this.game = game;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public void ability(Meme meme){}

    public void ability(Damagable damagable){}

    public void ability(){}
}

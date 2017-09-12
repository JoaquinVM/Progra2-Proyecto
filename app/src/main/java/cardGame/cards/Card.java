package cardGame.cards;

import android.support.annotation.NonNull;

import cardGame.Damagable;
import cardGame.Game;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Card implements Cloneable, Comparable{
    private int cost;
    private String name;
    private Game game;

    public Card clone() {
        try{
            return (Card)super.clone();
        }catch(CloneNotSupportedException c){
            return null;
        }
    }

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

    public boolean equals(Object o) {
        if(o instanceof Card){
            Card card = (Card) o;
            return cost == card.getCost() && name.equals(card.getName());
        }
        return false;
    }
    public String image(){
        return name;
    }

    @Override
    public int compareTo(@NonNull Object another) {
        if(another instanceof Card){
            Card c = (Card)another;
            if(cost < c.getCost()){
                return -1;
            }else if(cost > c.getCost()){
                return 1;
            }else{
                return 0;
            }
        }else{
            throw new IllegalArgumentException();
        }
    }
}

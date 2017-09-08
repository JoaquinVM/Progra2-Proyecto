package cardGame.utils;

import android.preference.PreferenceActivity;

import java.util.HashMap;
import java.util.Objects;

import cardGame.Buttom;
import cardGame.cards.Card;
import cardGame.MemeStoneUI;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Assets {

    private static Assets instance = new Assets();
    private MemeStoneUI ui;
    private HashMap<Object, String> map = new HashMap<>();

    public static Assets getInstance(){
        return instance;
    }

    public void init(MemeStoneUI ui){
        this.ui = ui;


    }

    public String image(Object object){
        return map.get(object);
    }

}

class Memeimage{
    private int health;
    private Card card;

    public Memeimage(Card c, int h){
        health = h;
        card = c;
    }

    public int getHealth() {
        return health;
    }

    public Card getCard() {
        return card;
    }


}

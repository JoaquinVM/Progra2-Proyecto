package cardGame.utils;

import java.util.HashMap;

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

class MemeImage {
    private int health;
    private Card card;

    public MemeImage(Card c, int h){
        health = h;
        card = c;
    }

    public int getHealth() {
        return health;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof MemeImage){
            MemeImage m = (MemeImage)o;
            return health == m.getHealth() && card.equals(m.getCard());
        }
        return false;
    }
}

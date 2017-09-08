package cardGame.utils;

import java.util.HashMap;

import cardGame.cards.Card;
import cardGame.MemeStoneUI;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Assets {
    //TODO check if class do something important or is dispensable

    private static Assets instance = new Assets();
    private MemeStoneUI ui;
    private HashMap<Card, String> map = new HashMap<>();

    public static Assets getInstance(){
        return instance;
    }

    public void init(MemeStoneUI ui){
        this.ui = ui;


    }

    public String image(Card card){
        return map.get(card.getName());
    }

    public String image(){
        return null;
    }

}

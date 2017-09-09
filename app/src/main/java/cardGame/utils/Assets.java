package cardGame.utils;

import java.util.HashMap;

import cardGame.Player;
import cardGame.cards.Card;
import cardGame.MemeStoneUI;
import cardGame.cards.CardDatabase;
import cardGame.cards.Meme;
import cardGame.player.PlayerFire;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Assets {

    private static Assets instance = new Assets();
    private MemeStoneUI ui;
    private static HashMap<Card, String> map = new HashMap<>();

    public static Assets getInstance(){
        return instance;
    }

    public void init(MemeStoneUI ui){
        this.ui = ui;

        CardDatabase db = CardDatabase.getInstance();

        for(Card c : db.getSpells()){
            map.put(c, c.getName());
        }

        for(Meme m : db.getMemes()){
            Meme meme = m.clone();
            map.put(meme, meme.getName());
            for(int i = 0; i < meme.getMaxHealth(); i++){
                meme.damage(1);
                map.put(meme, meme.getName()+"_"+meme.getHealth());
            }
        }
    }

    public String image(Card card){
        return map.get(card);
    }

    public String image(Player player, int health){
        return player.getType() + "_" + health;
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

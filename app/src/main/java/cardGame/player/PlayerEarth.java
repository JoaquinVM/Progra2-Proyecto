package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;



/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerEarth extends Player {
    public PlayerEarth(){
        super("Earth",30);
    }
    @Override
    public void power(Meme meme){
        getGame().increaseHealth(4);
    }
}

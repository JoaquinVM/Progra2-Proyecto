package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerIce extends Player {
    public PlayerIce(){
        super("Ice",30);
    }
    @Override
    public void power(Meme meme){
        getGame().freeze(meme);
    }
}

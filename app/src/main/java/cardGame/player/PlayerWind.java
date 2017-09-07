package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;



/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerWind extends Player {
    public PlayerWind(){
        super(30);
    }
    @Override
    public void power(Meme meme){
        getGame().damageAll(1);
    }
}

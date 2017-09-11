package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;
import cardGame.utils.Constants;
import cardGame.utils.Enums;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerIce extends Player {
    public PlayerIce(){
        setName("ice");
        setPowerImage(Constants.ICE_POWER);
    }
    @Override
    public void power(Meme meme){
        getGame().freeze(meme);
    }
}

package cardGame.player;

import cardGame.cards.Meme;
import cardGame.Constants;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerIce extends Player {
    public PlayerIce(){
        setName("ice");
        setPowerImage(Constants.ICE_POWER);
    }
    @Override
    public void power(){

        getGame().freeze(meme);
    }
}

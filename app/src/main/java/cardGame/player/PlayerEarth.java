package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;
import cardGame.utils.Constants;
import cardGame.utils.Enums;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerEarth extends Player {

    public PlayerEarth(){
        setName("earth");
        setPowerImage(Constants.EARTH_POWER);
    }


    @Override
    public void power(Meme meme){
        getGame().heal(meme, 4);
    }


}

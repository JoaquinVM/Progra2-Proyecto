package cardGame.player;

import cardGame.cards.Meme;
import cardGame.Constants;


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

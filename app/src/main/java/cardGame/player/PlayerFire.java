package cardGame.player;

import cardGame.cards.Meme;
import cardGame.Constants;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerFire extends Player {
    public PlayerFire(){
        setName("fire");
        setPowerImage(Constants.FIRE_POWER);
    }

    @Override
    public void power(Meme meme) {

        getGame().burn(meme);
    }
}

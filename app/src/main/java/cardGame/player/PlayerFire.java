package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;
import cardGame.utils.Constants;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerFire extends Player {
    public PlayerFire(String type){
        super(type);
        setPowerImage(Constants.FIRE_POWER);
    }

    @Override
    public void power(Meme meme) {

        getGame().burn(meme);
    }
}

package cardGame.player;

import cardGame.Player;
import cardGame.cards.Meme;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerFire extends Player {
    public PlayerFire() {

        super(30);
    }

    @Override
    public void power(Meme meme) {

        getGame().burn(meme);
    }
}

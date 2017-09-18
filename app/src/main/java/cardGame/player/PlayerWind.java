package cardGame.player;

import cardGame.Game;
import cardGame.cards.Meme;
import cardGame.Constants;


/**
 * Created by Rodrigo on 5/9/2017.
 */

public class PlayerWind extends Player {
    public PlayerWind(){
        setName("wind");
        setPowerImage(Constants.WIND_POWER);
    }
    @Override
    public void power(Game game){
        game.damageAll(1);
    }
}

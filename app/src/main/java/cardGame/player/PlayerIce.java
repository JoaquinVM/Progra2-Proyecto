package cardGame.player;

import cardGame.Game;
import cardGame.cards.CardDatabase;
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
    public void power(Game game){
        game.summon(CardDatabase.getInstance().getElemental(game));
    }
}

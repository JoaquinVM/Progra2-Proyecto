package cardGame;

import cardGame.cards.Card;
import cardGame.cards.Meme;

/**
 * Created by Rodrigo on 5/9/2017.
 */

public class Game {
    private MemeStoneUI memeUI;
  //  private Meme meme;

    public Game(MemeStoneUI memeUI) {
        this.memeUI = memeUI;
    }

    public void freeze(Meme meme) {
        meme.setCanAttack(false);
    }

    public void burn(Meme meme) {
        meme.burn();
    }
    public void increaseHealth(int n,Meme meme){
        meme.increaseHealth(n,meme);
    }
    public void attackAll(int n){
        //TODO pensar
    }
}

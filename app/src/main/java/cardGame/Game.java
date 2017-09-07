package cardGame;

import cardGame.cards.Card;
import cardGame.cards.Meme;

/**
 * Created by Rodrigo on 5/9/2017.
 */

public class Game {
    private MemeStoneUI memeUI;
    private Player p1;
    private Player p2;

    public Game(MemeStoneUI memeUI, Player p1, Player p2) {
        //TODO memeUI no se usa
        this.memeUI = memeUI;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void freeze(Meme meme) {
        meme.setCanAttack(false);
    }

    public void burn(Meme meme) {
        meme.burn();
    }

    public void increaseHealth(int n, Meme meme) {
        meme.increaseHealth(n, meme);
    }

    public void attackAll(int n) {
        //TODO pensar
        //TODO que habra aqui?
    }

    public void dealDamage(Damagable d, int damage) {
        d.damage(damage);
    }
}

package cardGame;

import java.util.Random;

import cardGame.cards.Meme;

/**
 * Created by Rodrigo on 5/9/2017.
 */

public class Game {
    private MemeStoneUI memeUI;
    private Player player;
    private Player enemy;

    public Game(MemeStoneUI memeUI, Player player, Player enemy) {
        //TODO memeUI no se usa
        this.memeUI = memeUI;
        this.player = player;
        this.enemy = enemy;
    }

    public void freeze(Meme meme) {
        meme.setCanAttack(false);
    }

    public void burn(Meme meme) {
        //TODO completar
    }

    public void increaseHealth(int n, Meme meme) {
        meme.increaseHealth(n, meme);
    }

    public void damageAll(int damage) {
        //TODO pensar
        //TODO que habra aqui?//ni idea
    }

    public void damageEnemies(int damage){

    }

    public void dealDamage(Damagable d, int damage) {
        d.damage(damage);
    }

    public void heal(Damagable d, int health){
        d.heal(health);
    }

    public void destroy(Meme m){
        //TODO
    }

    public void control(Meme m){
        //TODO
    }

    public void damageRandomEnemies(int numEnemy, int damage){
        Random r = new Random();
        for(int i = 0; i < numEnemy; i++){
            int n = r.nextInt(player.getArena().size());
            dealDamage(player.getArena().get(n), damage);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Player getEnemy() {
        return enemy;
    }

}

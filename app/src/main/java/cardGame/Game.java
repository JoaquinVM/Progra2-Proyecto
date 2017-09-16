package cardGame;

import java.util.Random;

import cardGame.cards.Meme;
import cardGame.player.Player;
import cardGame.screens.Screen;

/**
 * Created by Rodrigo on 5/9/2017.
 */

public class Game{
    private MemeStoneUI memeUI;
    private Player player;
    private Player enemy;
    private Random r = new Random();


    public Game(MemeStoneUI ui){
        this.memeUI = ui;
    }

    public void init(){
        player.increaseMana();
        for(int i = 0; i < 3; i++){
            player.drawCard();
            enemy.drawCard();
        }
    }

    public void nextTurn(){
        for(Meme m : player.getArena()){
                m.setCanAttack(true);
        }
        Player aux = player;
        player = enemy;
        enemy = aux;
        player.increaseMana();

        player.drawCard();
        if(player.getHand().size() > 6){
            player.getHand().remove(player.getHand().size() - 1);
        }
    }

    public void freeze(Meme meme) {
        meme.setCanAttack(false);
    }

    public void burn(Meme meme) {
        meme.damage(1);
    }

    public void damageAll(int damage) {
        for(Meme m : player.getArena()){
            m.damage(damage);
        }
        player.damage(1);
        damageEnemies(damage);
    }

    public void damageEnemies(int damage){
        for(Meme m : enemy.getArena()){
            m.damage(damage);
        }
        enemy.damage(1);
    }

    public void dealDamage(cardGame.Damagable d, int damage) {
        d.damage(damage);
    }

    public void heal(cardGame.Damagable d, int health){
        d.heal(health);
    }

    public void destroy(Meme m){
        m.killMeme(m);
    }

    public void control(Meme m){
        enemy.getArena().remove(m);
        player.getArena().add(m);
    }

    public void damageRandomEnemies(int numEnemy, int damage){
        for(int i = 0; i < numEnemy; i++){
            int n = r.nextInt(player.getArena().size());
            dealDamage(player.getArena().get(n), damage);
        }
    }

    public void healAllies(int health){
        for(Meme m : player.getArena())m.heal(health);
    }

    public void resurrect(){
        int index = r.nextInt(player.getGraveyard().size());
        player.getArena().add(player.getGraveyard().get(index));
    }
    public void discard(){
        int n = r.nextInt(player.getHand().size());
        player.getHand().remove(n);
    }

    public void summon(Meme meme){
        if(player.getArena().size() < Constants.MAX_CARDS_PER_ROW){
            player.getArena().add(meme);
        }
    }

    public void fight(Meme meme1, Meme meme2){
        meme1.damage(meme2.getDamage());
        meme2.damage(meme1.getDamage());
    }

    public Player getPlayer() {
        return player;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
}

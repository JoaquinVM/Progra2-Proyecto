package cardGame.cards;

import cardGame.Damagable;
import cardGame.utils.Assets;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Meme extends Card implements Damagable{

    private int damage;
    private int health;
    private boolean dead = false;
    private boolean taunt = false;
    private boolean poisonous = false;
    private boolean charge = false;
    private boolean speelInmune = false;
    private boolean canAttack = false;

    public Meme(String name, int cost, int damage, int health) {
        super(name, cost);
        this.damage = damage;
        this.health = health;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public void setSpellinmune(boolean spellinmune) {
        this.speelInmune = spellinmune;
    }

    public void setCanAttack(boolean canAttack){
        this.canAttack = canAttack;
    }

    public void image(){
        Assets.getInstance().image(this);
    }
    public void burn(){
        while(health>=0) {
            health--;
        }
        // TODO falta que sea cada turno
        //TODO game deberia hacer el burn

    }
    public void increaseHealth(int n, Meme healedMeme){
        health+=n;
    }

    @Override
    public void damage(int damage) {
        health -= damage;
        dead = health <= 0;
    }
}

package cardGame.cards;

import cardGame.utils.Assets;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Meme extends Card {

    private int damage;
    private int health;
    private boolean taunt = false;
    private boolean poisonous = false;
    private boolean charge = false;
    private boolean speelInmune = false;

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

    public void draw(){
        Assets.getInstance().image(this);
    }
}

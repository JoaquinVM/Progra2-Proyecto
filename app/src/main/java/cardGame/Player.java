package cardGame;


import cardGame.cards.Meme;

/**
 * Created by Rodrigo on 5/9/2017.
 */


public abstract class Player implements Damagable{
    private int health;
    private String name;
    private String type;
    private Game game;
    private boolean dead = false;
    public Player(String type, int health){
        this.type=type;
        this.health=health;
    }
    public void damaged(int damage){
        health-=damage;
    }
    public int getHealth(){
        return health;
    }
    public String getType(){
        return type;
    }
    public Game getGame(){
        return game;
    }
    public abstract void power(Meme meme);

    @Override
    public void damage(int damage) {
        health -= damage;
        if(health <= 0){
            dead = true;
        }
    }
}

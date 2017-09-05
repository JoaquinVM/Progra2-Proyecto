package cardGame;


import cardGame.cards.Meme;

/**
 * Created by Rodrigo on 5/9/2017.
 */


public abstract class Player {
    private int health;
    private String name;
    private String type;
    private Game game;
    public Player(String type, int health){
        this.type=type;
        this.health=health;
    }
    public void damaged(int damage){
        health-=damage;
    }
    public Game getGame(){
        return game;
    }
    public abstract void power(Meme meme);

}

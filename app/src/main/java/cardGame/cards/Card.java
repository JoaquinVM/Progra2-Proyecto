package cardGame.cards;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Card {
    private int cost;
    private String name;

    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

}

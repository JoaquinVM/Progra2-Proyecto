package cardGame.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import cardGame.Game;
import cardGame.utils.Constants;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Deck {
    private Game game;

    private List<Card> initialDeck = new LinkedList<>();
    private Stack<Card> deck = new Stack<>();
    private int maxCards = Constants.MAX_CARDS_PER_DECK;

    public Deck (List<Card> initialDeck) {
        this.initialDeck = initialDeck;
    }

    public void add(Card card){
        initialDeck.add(card);
    }

    public Card drawCard(){
        return deck.pop();
    }

    public void shuffle(){
        Collections.shuffle(initialDeck);
        for(int i = 0; i < initialDeck.size(); i++){
            deck.push(initialDeck.remove(0));
        }
    }

    public Game getGame() {
        return game;
    }


}

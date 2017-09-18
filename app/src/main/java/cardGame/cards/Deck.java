package cardGame.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import cardGame.Game;
import cardGame.Constants;

/**
 * Created by Joaco99 on 05/09/2017.
 */

public class Deck {
    private Game game;

    private List<Card> initialDeck = new LinkedList<>();
    private Stack<Card> deck = new Stack<>();

    public Deck (List<Card> initialDeck) {
        this.initialDeck = initialDeck;
        shuffle();
    }

    public void add(Card card){
        initialDeck.add(card);
    }

    public Card drawCard() throws DeckIsEmptyException{
        if(deck.size() > 0){
            return deck.pop();
        }else{
            throw new DeckIsEmptyException();
        }
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

    public static Deck randomDeck(){
        List<Card> cards = new LinkedList<>();
        //List<Card> spells = CardDatabase.getInstance().getSpells();
        List<Meme> memes = CardDatabase.getInstance().getMemes();

        Random r = new Random();

        for(int i = 0; i < Constants.MAX_CARDS_PER_DECK; i++){
            boolean s = r.nextBoolean();
            cards.add(memes.get(r.nextInt(memes.size())).clone());

        }
        return  new Deck(cards);
    }

}

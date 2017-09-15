package cardGame.screens;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Card;
import cardGame.cards.CardDatabase;
import cardGame.cards.Deck;
import cardGame.utils.Constants;


/**
 * Created by Samuel on 12/09/2017.
 */

public class CardSelectionScreen implements Screen {

    private MemeStoneUI ui;
    private Player player1;
    private Player player2;
    private List<Card> cards;
    private List<Card> deck;
    private int page = 0;
    private int deckPage = 0;
    private int selectedV = -1;
    private int selectedH = -1;
    private boolean sPlayer1 = true;
    private Map<Card, Integer> map = new HashMap<>();

    public CardSelectionScreen(MemeStoneUI ui, Player player1, Player player2) {
        cards = new LinkedList<>();
        deck = new LinkedList<>();
        this.ui = ui;
        this.player1 = player1;
        this.player2 = player2;
        cards.addAll(CardDatabase.getInstance().getSpells());
        cards.addAll(CardDatabase.getInstance().getMemes());
        Collections.sort(cards);
    }

    public void init(){
        page = 0;
        deckPage = 0;
        selectedV = -1;
        selectedH = -1;
        map.clear();
        deck.clear();
    }

    @Override
    public void show() {
        ui.configureGrid(3, 8, 0, 0, 0);
        drawPage();
        drawDeck();
        ui.setImageOnCell(0, 6, "show");
        ui.setImageOnCell(1, 6, "add");
        ui.setImageOnCell(2, 6, "delete");
        ui.setImageOnCell(0, 7, "right");
        ui.setImageOnCell(1, 7, "end");
        ui.setImageOnCell(2, 7, "right");

    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        if (h == 6) {
            if (v == 0) {
                //show
                if(selectedV == 0 || selectedV == 1){
                    ui.setScreen(new CardPreviewScreen(ui, this, cards.get(12 * page + 6 * selectedV + selectedH).image()));
                }else{
                    ui.setScreen(new CardPreviewScreen(ui, this, deck.get(deckPage * 6 + selectedH).image()));
                }
            } else if (v == 1) {
                //add
                if (selectedV >= 0 && selectedV < 2 && selectedH >= 0 && selectedH < 6 && deck.size() < Constants.MAX_CARDS_PER_DECK) {
                   int index = 12 * page + 6 * selectedV + selectedH;
                    if(map.get(cards.get(index)) == null || map.get(cards.get(index)) < 2){
                        deck.add(cards.get(12 * page + 6 * selectedV + selectedH).clone());
                        drawDeck();
                    }
                    changeMap(cards.get(index), true);
                }
            } else if (v == 2) {
                if (selectedV == 2 && selectedH < 6) {
                    //delete
                    int index = deckPage * 6 + selectedH;
                    if(index < deck.size()){
                        changeMap(deck.get(index), false);
                        deck.remove(index);
                        drawDeck();
                    }
                }
            }
        } else if (h == 7) {
            if (v == 0) {
                //rightPage
                page++;
                if (page > cards.size() / 12){
                    page = 0;
                }
                drawPage();
            } else if (v == 1 && deck.size() == Constants.MAX_CARDS_PER_DECK){
                //end
                if(sPlayer1){
                    sPlayer1 = false;
                    player1.setDeck(new Deck(deck));
                    init();
                    show();
                }else{
                    player2.setDeck(new Deck(deck));
                    ui.setScreen(new GameScreen(ui, player1, player2));
                }
            }else if(v == 2){
                //rightDeck
                deckPage++;
                if (deckPage >  deck.size() / 6){
                    deckPage = 0;
                }
                drawDeck();
            }
        }else{
            if(h != 6 && h != 7){
                selectedV = v;
                selectedH = h;
            }
        }
    }

    @Override
    public void hide() {
    }

    public void changeMap(Card card, boolean add){

        if((map.get(card) == null || map.get(card) == 0)&& add){
            map.put(card, 1);
        }else if(map.get(card) == 1 && add){
            map.put(card, 2);
        }else if(map.get(card) == 1 && !add){
            map.put(card, 0);
        }else if(map.get(card) == 2 && !add){
            map.put(card, 1);
        }


    }

    public void drawPage() {
        int index = page * 12;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (index < cards.size()) {
                    ui.setImageOnCell(i, j, cards.get(index).image());
                } else {
                    ui.setImageOnCell(i, j, "fondo_v");
                }
                index++;
            }
        }
    }

    public void drawDeck(){
        for (int i = 0; i < 6; i++) {
            if(deckPage * 6+ i < deck.size()){
                ui.setImageOnCell(2, i, deck.get(deckPage * 6 + i).image());
            } else {
                ui.setImageOnCell(2,i ,"fondo_v");
            }
        }
    }
}

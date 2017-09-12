package cardGame.screens;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Card;
import cardGame.cards.CardDatabase;
import cardGame.cards.Deck;
import cardGame.cards.Meme;
import cardGame.utils.Constants;

/**
 * Created by Joaco99 on 12/09/2017.
 */

public class CardSelectionScreen implements Screen {

    private MemeStoneUI ui;
    private Player player1;
    private Player player2;
    private List<Card> cards = new LinkedList<>();
    private List<Card> deck = new LinkedList<>();
    private int page = 1;
    private int deckPage = 0;
    private int selectedV = -1;
    private int selecteH = -1;
    private boolean sPlayer1 = true;

    public CardSelectionScreen(MemeStoneUI ui, Player player1, Player player2) {
        this.ui = ui;
        this.player1 = player1;
        this.player2 = player2;
        cards.addAll(CardDatabase.getInstance().getSpells());
        cards.addAll(CardDatabase.getInstance().getMemes());
    }

    @Override
    public void show() {
        ui.configureGrid(3, 8, 0, 0, 0);
        page = 1;
        deckPage = 0;
        deck.clear();

        Collections.sort(cards);

        drawPage();
        drawDeck();


    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        if (h == 6) {
            if (v == 0) {
                //ui.setScreen(new CardPreviewScreen(ui, ));
            } else if (v == 1) {
                if (selectedV >= 0 && selectedV < 2 && selecteH >= 0 && selecteH < 6) {
                    deck.add(cards.get(6 * (page + v) + h));
                    drawDeck();
                }
            } else if (v == 2) {
                if (selectedV == 2 && h < 6) {
                    deck.remove(selecteH);
                    drawDeck();
                }
            }
        } else if (h == 7) {
            if (v == 0) {
                page++;
                if (page > cards.size() / 12){
                    page = 1;
                }
                drawPage();
            } else if (v == 1 && cards.size() == Constants.MAX_CARDS_PER_DECK){
                if(sPlayer1){
                    sPlayer1 = false;
                    player1.setDeck(new Deck(deck));
                    show();
                }else{
                    player2.setDeck(new Deck(deck));
                    ui.setScreen(new GameScreen(ui, player1, player2));
                }
            }else if(v == 2){
                deckPage++;
                if (deckPage > deck.size() / 6){
                    deckPage = 1;
                }
                drawDeck();
            }
        }
    }

    @Override
    public void hide() {

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
        for (int i = deckPage; i < 6; i++) {
            if(i < deck.size()){
                ui.setImageOnCell(2, i, deck.get(i).image());
            } else {
                ui.setImageOnCell(2,i ,"fondo_v");
            }
        }
    }
}

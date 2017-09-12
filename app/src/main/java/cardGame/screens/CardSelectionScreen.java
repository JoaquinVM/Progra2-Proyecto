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
    private int page = 0;
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

        Collections.sort(cards);

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
                ui.setScreen(new CardPreviewScreen(ui, this, cards.get(0)));
            } else if (v == 1) {
                //add
                if (selectedV >= 0 && selectedV < 2 && selecteH >= 0 && selecteH < 6) {
                    deck.add(cards.get(12 * (page + selectedV) + selecteH));
                    drawDeck();
                }
            } else if (v == 2) {
                if (selectedV == 2 && selecteH < 6) {
                    //delete
                    deck.remove(selecteH + deckPage);
                    drawDeck();
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
            } else if (v == 1 && cards.size() == Constants.MAX_CARDS_PER_DECK){
                //en
                if(sPlayer1){
                    sPlayer1 = false;
                    player1.setDeck(new Deck(deck));
                    show();
                    page = 0;
                    deckPage = 0;
                    deck.clear();
                }else{
                    player2.setDeck(new Deck(deck));
                    ui.setScreen(new GameScreen(ui, player1, player2));
                }
            }else if(v == 2){
                //rightDeck
                deckPage++;
                if (deckPage > deck.size() / 6){
                    deckPage = 1;
                }
                drawDeck();
            }
        }else{
            if(selectedV == -1 && selecteH == -1){
                selectedV = v;
                selecteH = h;
            }else{
                selectedV = -1;
                selecteH = -1;
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

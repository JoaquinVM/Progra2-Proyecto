package cardGame.screens;

import java.util.LinkedList;
import java.util.List;

import cardGame.Game;
import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Card;
import cardGame.cards.CardDatabase;
import cardGame.cards.Deck;


/**
 * Created by Samuel on 08/09/2017.
 */

public class CardSelectionScreen implements Screen {
    private MemeStoneUI ui;
    private List<Card> selectedCards = new LinkedList<>();
    private List<Card> cardList = new LinkedList<>();
    private int pageCardList = 0;
    private int pageSelectedCards = 0;
    private int selectedV = -1, selectedH = -1;
    private Card[][] cardMat = new Card[3][6];
    private Card[] selectedCardVec = new Card[6];
    private Player player1;
    private Player player2;
    private boolean sPlayer1 = true;


    public CardSelectionScreen(MemeStoneUI ui, Player player1, Player player2){
        this.ui = ui;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void orderList(List<Card> cardList) {
        Card aux;
        for (int i = 0; i < cardList.size(); i++) {
            for (int j = i + 1; j < cardList.size() - 1; j++) {
                if (cardList.get(i).getCost() > cardList.get(j).getCost()) {
                    aux = cardList.get(i);
                    cardList.add(i, cardList.get(j));
                    cardList.add(j, aux);
                }
            }
        }
        this.cardList = cardList;
    }


    public void setCardsOnBoardByButton(List<Card> lista) {
        if (lista.get(pageCardList + 12) == null) {
            pageCardList = 0;
        } else {
            pageCardList += 12;
        }
        int indice = pageCardList;
        setCardsOnBoard(lista, indice);
    }

    public void setCardsOnBoard(List<Card> lista, int indice) {
        for (int v = 0; v < 2; v++) {
            for (int h = 0; h < 6; h++) {
                if (!(lista.get(indice) == null)) {
                    ui.setImageOnCell(v, h, lista.get(indice).image());
                    indice++;
                } else {
                    ui.setImageOnCell(v, h, "fondo_v");
                }
            }
        }
    }

    public void setSellectedCardsOnBoard(List<Card> lista, int indice) {
        for (int h = 0; h < 6; h++) {
            if (!(lista.get(indice) == null)) {
                ui.setImageOnCell(2, h, lista.get(indice).image());
                indice++;
            } else {
                ui.setImageOnCell(2, h, "fondo_v");
            }
        }
    }

    public void createMatrix(List<Card> cardList) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                cardMat[i][j] = cardList.get(pageCardList + (i*6-1) + j);
            }
        }
    }

    public void createVector(List<Card> cardList) {
        if (!selectedCards.isEmpty()){
            for (int i = 0; i < 6; i++) {
                selectedCardVec[i] = cardList.get(pageSelectedCards + i);
            }
        }
    }
    public void slideSelectedCards(List<Card> lista) {
        if (lista.get(pageSelectedCards + 6) == null) {
            pageSelectedCards = 0;
        } else {
            pageSelectedCards += 6;
        }
        int indice = pageSelectedCards;
        setSellectedCardsOnBoard(lista, indice);
    }

    public void addCardsToDeck(int v, int h) {
        if ((!selectedCards.contains(cardMat[v][h])) && selectedCards.size()<20) {
            selectedCards.add(cardMat[v][h]);
        }
    }

    public void deleteCards(int h) {
        selectedCards.remove(pageSelectedCards + h );
    }

    @Override
    public void show(){

    }

    public void showd() {
        ui.configureGrid(3, 8, 0, 0, 0);
        if(sPlayer1){
            for(Card m : CardDatabase.getInstance().getMemes()){
                cardList.add(m.clone());
            }
            for(Card s : CardDatabase.getInstance().getSpells()){
                cardList.add(s.clone());
            }
        }

        orderList(cardList);
        setCardsOnBoard(cardList, 0);
        createMatrix(cardList);
        setSellectedCardsOnBoard(selectedCards, 0);
        Deck d = new Deck(selectedCards);
        if(sPlayer1) {
            sPlayer1 = false;
            player1.setDeck(d);
            selectedCards.removeAll(selectedCards);
            show();

        } else{
            player2.setDeck(d);
            ui.setScreen(new GameScreen(ui, player1, player2));
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        if (h == 6) {
            if (v == 0) {
                //show//TODO
            } else if (v == 1) {
                //add cards to deck
                addCardsToDeck(selectedV, selectedH);
                setSellectedCardsOnBoard(selectedCards, pageSelectedCards);
                createVector(selectedCards);
            } else {
                show();//TODO
            }
        } else if (h == 7) {
            if (v == 0) {
                //go next page selectable cards
                setCardsOnBoardByButton(cardList);
                createMatrix(cardList);
            } else if (v == 1) {
                //delete cards from deck
                deleteCards(selectedV);
                setSellectedCardsOnBoard(selectedCards, pageSelectedCards);
                createVector(selectedCards);
            } else {
                //go next page deck
                slideSelectedCards(selectedCards);
                createVector(selectedCards);
            }
        } else if (v > -1 && v < 6 && h > -1 && h < 2) {
            selectedV = v;
            selectedH = h;
        } else {
            selectedV = v;
            selectedH = h;
        }
    }

    @Override
    public void hide() {
        //TODO
    }
}
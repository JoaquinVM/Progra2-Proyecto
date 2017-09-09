package cardGame.screens;

import java.util.LinkedList;
import java.util.List;

import cardGame.MemeStoneUI;
import cardGame.cards.Card;

/**
 * Created by Samuel on 08/09/2017.
 */

public class CardSelectionScreen implements Screen {
    private MemeStoneUI ui;
    private Screen screen;
    private List<Card> usedCards;
    private  List<Card> cardList;



    public CardSelectionScreen(MemeStoneUI ui){
        this.ui = ui;
    }



    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void recivirListas(List<Card> cardList){
        List<Card> usedCards = new LinkedList<Card>();
        this.cardList = cardList;
        this.usedCards = usedCards;
    }



    public void setCardsOnBoard(List<Card> lista){
        int indice = lista.size();
        int o = 0;
        for(int v =0; v < 2; v++){
            for(int h = 0; h < 6;h++){
                ui.setImageOnCell(v, h, lista.get(o).getName());
                o++;
            }
        }
    }


    @Override
    public void show() {
        ui.configureGrid(3,8,0,0,0);


    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        if(h == 6){
            if(v == 0){
                //menu
            } else if(v == 1){
                //add
            } else {
                //derecha cartas usadas
            }
        } else if(h ==7){
            if(v == 0){

            } else if(v == 1){
                //delete cartas usadas
            } else {
                //fin
            }
        }

    }

    @Override
    public void hide() {

    }


}





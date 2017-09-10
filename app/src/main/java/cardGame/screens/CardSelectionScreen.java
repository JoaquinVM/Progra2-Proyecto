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
    private List<Card> selectedCards;
    private  List<Card> cardList;
    private int páginaCartasAEscoger = 0;
    private int pageSelectedCards = 0;
    private boolean finalDeLista = false;



    public CardSelectionScreen(MemeStoneUI ui){
        this.ui = ui;
    }



    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void recibirYOrdenarLista(List<Card> cardList){
        //List<Card> usedCards = new LinkedList<Card>();TODO tienes que crearla durante la seleccion
        Card aux = null;
        for(int i = 0;i<cardList.size();i++){
            for(int j = i +1 ;j<cardList.size()-1 ;j++){
                if(cardList.get(i).getCost() > cardList.get(j).getCost()){
                    aux = cardList.get(i);
                    cardList.add(i, cardList.get(j));
                    cardList.add(j, aux);
                }
            }
        }
        this.cardList = cardList;
        //this.usedCards = usedCards;TODO
    }



    public void setCardsOnBoardByButtom(List<Card> lista){
        if(lista.get(páginaCartasAEscoger + 18) == null){
          páginaCartasAEscoger = 0;
        } else  {
          páginaCartasAEscoger += 18;
        }
        int indice = páginaCartasAEscoger;
        setCardsOnBoard(lista, indice);
    }

    public void setCardsOnBoard(List<Card> lista,int indice){
        for(int v =0; v < 2; v++){
            for(int h = 0; h < 6;h++){
                if(!(lista.get(indice) == null)){
                    ui.setImageOnCell(v, h, lista.get(indice).getName());
                    indice++;
                }else{
                    ui.setImageOnCell(v,h, "fondo_v");
                }
            }
        }
    }
    public void slideSelectedCards(List<Card> lista){
        if(lista.get(pageSelectedCards+8) == null){
            pageSelectedCards = 0;
        }else{
            pageSelectedCards +=8;
        }
        int indice = pageSelectedCards;
        setSellectedCardsOnBoard(lista, indice);
    }
    public void setSellectedCardsOnBoard(List<Card> lista,int indice){
        for(int h = 0; h < 8; h++ ){
            if(!(lista.get(indice) == null)){
                ui.setImageOnCell(3, h, lista.get(indice).getName());
                indice++;
            }else{
                ui.setImageOnCell(3,h, "fondo_v");
            }
        }
    }

    public void addCardsToDeck(){
        //TODO

    }


    @Override
    public void show() {
        ui.configureGrid(3,8,0,0,0);
        setCardsOnBoard(cardList, 0);
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        if(h == 6){
            if(v == 0){
                //show
            } else if(v == 1){
                //add
            } else {
                //fin
            }
        } else if(h ==7) {
            if (v == 0) {
                setCardsOnBoardByButtom(cardList);
            } else if (v == 1) {
                //delete cartas usadas
            } else {
                slideSelectedCards(selectedCards);
            }
        }
    }

    @Override
    public void hide() {
        //TODO a quiíen llamo despues
        //a mi mismo si no es false
    }


}





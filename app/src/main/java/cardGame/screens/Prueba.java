package cardGame.screens;

import java.util.LinkedList;
import java.util.List;

import cardGame.MemeStoneUI;
import cardGame.cards.Card;
import cardGame.cards.CardDatabase;

/**
 * Created by Joaco99 on 11/09/2017.
 */

public class Prueba implements Screen {
    List<Card> list = new LinkedList<>();
    MemeStoneUI ui;

    public Prueba(MemeStoneUI ui){
        this.ui = ui;
    }

    @Override
    public void show() {
        list.addAll(CardDatabase.getInstance().getSpells());
        ui.configureGrid(2, 2, 0, 0, 0);
        for(int i = 0; i< 2; i++){
            for(int j = 0; j< 2; j++){
                ui.setImageOnCell(i, j, list.get(i+j).getName());

            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {

    }

    @Override
    public void hide() {

    }
}

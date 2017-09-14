package cardGame.screens;

import cardGame.MemeStoneUI;
import cardGame.cards.Card;

/**
 * Created by Joaco99 on 06/09/2017.
 */

public class CardPreviewScreen implements Screen {
    MemeStoneUI ui;
    String image;
    Screen screen;

    public CardPreviewScreen(MemeStoneUI ui, Screen screen, String image) {
        this.ui = ui;
        this.screen = screen;
        this.image = image;
    }



    @Override
    public void show() {
        ui.configureGrid(1, 3, 0, 0, 0);
        ui.setImageOnCell(0, 0, "fondo_v");
        ui.setImageOnCell(0, 1, image);
        ui.setImageOnCell(0,2,"fondo_v");
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        ui.setScreen(screen);
    }

    @Override
    public void hide() {
    }


}

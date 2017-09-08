package cardGame.screens;

import cardGame.MemeStoneUI;
import cardGame.cards.Card;
import cardGame.utils.Assets;

/**
 * Created by Joaco99 on 06/09/2017.
 */

public class CardPreviewScreen implements Screen {
    MemeStoneUI ui;
    Card card;
    Screen screen;

    public CardPreviewScreen(MemeStoneUI ui, Screen screen) {
        this.ui = ui;
        this.screen = screen;
    }

    public CardPreviewScreen(MemeStoneUI ui) {
        this.ui = ui;
    }

    @Override
    public void show() {
        ui.configureGrid(1, 3, 0, 0, 0);
        ui.setImageOnCell(0, 1, "card_preview");
        ui.setImageOnCell(0, 1, "alexis");
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        this.hide();
    }

    @Override
    public void hide() {
        screen.show();
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}

package cardGame.screens;

import cardGame.MemeStoneUI;

/**
 * Created by Rodrigo on 17/9/2017.
 */

public class WinScreen implements Screen {

    MemeStoneUI ui;

    public WinScreen(MemeStoneUI ui) {
        this.ui = ui;
    }

    @Override
    public void show() {
        ui.configureGrid(1, 1, 0, 0, 0);
        ui.setImageOnCell(0, 0, "game_over");
    }

    @Override
    public void onCellPressed(int v, int h) {
        ui.setScreen(new MenuScreen(ui, true, null));
    }
}

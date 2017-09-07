package cardGame.screens;

import cardGame.MemeStoneUI;

/**
 * Created by Joaco99 on 06/09/2017.
 */


public class MenuScreen implements Screen  {

    private MemeStoneUI ui;


    public MenuScreen(MemeStoneUI ui){
        this.ui = ui;
    }
    @Override

    public void show() {
        ui.configureGrid(4,3,0,0,0);
    }

    @Override
    public void update() {
        // TODO
    }

    @Override
    public void onCellPressed(int v, int h) {
        // TODO
    }

    @Override
    public void hide() {
        // TODO
    }
}

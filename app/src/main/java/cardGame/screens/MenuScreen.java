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
        ui.configureGrid(4,2,0,0,0);
        int k = 1;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 4; j++){
                    ui.setImageOnCell(j, i, "menu_screen_" + k);
                k++;
            }
        }
    }

    @Override
    public void update() {
        // TODO
    }

    @Override
    public void onCellPressed(int v, int h) {
        if(v==1 && h==0){
            ui.setScreen(new PlayerSelectionScreen(ui));
        }else if(v==2 && h==0){
            System.exit(0);
        }
    }

    @Override
    public void hide() {

    }
}

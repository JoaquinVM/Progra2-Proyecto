package cardGame.screens;

import cardGame.MemeStoneUI;

/**
 * Created by Joaco99 on 06/09/2017.
 */


public class MenuScreen implements Screen  {

    private MemeStoneUI ui;
    private boolean firstMenu;
    private Screen screen;

    public MenuScreen(MemeStoneUI ui, boolean firstMenu, Screen screen){
        this.ui = ui;
        this.firstMenu = firstMenu;
        this.screen = screen;
    }


    @Override
    public void show() {
        ui.configureGrid(4,2,0,0,0);
        int k = 1;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 4; j++){
                if(i == 0 && j == 2 && !firstMenu)
                    ui.setImageOnCell(j, i, "menu_screen_return");
                else
                    ui.setImageOnCell(j, i, "menu_screen_" + k);
                k++;
            }
        }
    }

    @Override
    public void onCellPressed(int v, int h) {
        if(v==1 && h==0){
            ui.newGame();
        }else if(v==2 && h==0){
            if(firstMenu){
                System.exit(0);
            }else{
                if(screen != null){
                    ui.setScreen(screen);
                }
            }
        }
    }

}

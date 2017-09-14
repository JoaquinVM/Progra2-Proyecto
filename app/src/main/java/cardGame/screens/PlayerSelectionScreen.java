package cardGame.screens;

import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.player.PlayerEarth;
import cardGame.player.PlayerFire;
import cardGame.player.PlayerIce;
import cardGame.player.PlayerWind;

/**
 * Created by Rodrigo on 9/9/2017.
 */

public class PlayerSelectionScreen implements Screen {
    private MemeStoneUI ui;
    private boolean sPlayer1 = true;
    private Player player1;
    private Player player2;

    public PlayerSelectionScreen(MemeStoneUI ui) {
        this.ui = ui;
    }

    @Override
    public void show() {
        ui.configureGrid(2, 4, 0, 0, 0);
        String number = sPlayer1 ? "1" : "2";
        ui.setImageOnCell(0, 1, "fire_" + number);
        ui.setImageOnCell(0, 3, "ice_" + number);
        ui.setImageOnCell(1, 1, "earth_" + number);
        ui.setImageOnCell(1, 3, "wind_" + number);
        ui.setImageOnCell(0, 0, "fire_power");
        ui.setImageOnCell(0, 2, "ice_power");
        ui.setImageOnCell(1, 0, "earth_power");
        ui.setImageOnCell(1, 2, "wind_power");
    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {
        Player p = new PlayerFire();
        boolean choosed = false;
        if (v == 0){
            if (h == 0){
                ui.setScreen(new CardPreviewScreen(ui, this, "fire_power"));
            }else if(h == 1){
                p = new PlayerFire();
                choosed = true;
            }else if (h == 2){
                ui.setScreen(new CardPreviewScreen(ui, this, "ice_power"));
            }else {
                p = new PlayerIce();
                choosed = true;
            }
        } else if (v == 1){
            if (h == 0){
                ui.setScreen(new CardPreviewScreen(ui, this, "earth_power"));
            }else if(h == 1){
                p = new PlayerEarth();
                choosed = true;
            }else if (h == 2){
                ui.setScreen(new CardPreviewScreen(ui, this, "wind_power"));
            }else {
                p = new PlayerWind();
                choosed = true;
            }
        }
        if (sPlayer1 && choosed) {
            player1 = p;
            sPlayer1 = false;
            show();
        } else if(choosed){
            player2 = p;
            ui.setScreen(new CardSelectionScreen(ui, player1, player2));
        }

    }

    @Override
    public void hide() {
    }
}

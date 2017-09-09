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
    private GameScreen gameScreen = new GameScreen(ui);
    private boolean player1 = true;

    public PlayerSelectionScreen(MemeStoneUI ui) {
        this.ui = ui;
    }

    @Override
    public void show() {
        ui.configureGrid(2, 4, 0, 0, 0);
        if (player1) {
            ui.setImageOnCell(0, 1, "fire_1");
            ui.setImageOnCell(0, 3, "ice_1");
            ui.setImageOnCell(1, 1, "earth_1");
            ui.setImageOnCell(1, 3, "wind_1");
        } else {
            ui.setImageOnCell(0, 1, "fire_2");
            ui.setImageOnCell(0, 3, "ice_2");
            ui.setImageOnCell(1, 1, "earth_2");
            ui.setImageOnCell(1, 3, "wind_2");
        }
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
        Player p;
        if (v < 2 && h == 0) {
            p = new PlayerFire();
        } else if (v < 4 && h == 0) {
            p = new PlayerIce();
        } else if (v < 2 && h == 2) {
            p = new PlayerEarth();
        } else {
            p = new PlayerWind();
        }
        if (player1) {
            gameScreen.setPlayer1(p);
        } else {
            gameScreen.setPlayer2(p);
            hide();
        }
        player1 = false;
        show();
    }

    @Override
    public void hide() {
        Screen sc= new CardSelectionScreen(ui);
        sc.show();
    }
}

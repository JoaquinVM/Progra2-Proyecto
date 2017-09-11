package cardGame.screens;
import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.player.PlayerEarth;
import cardGame.player.PlayerFire;
import cardGame.player.PlayerIce;
import cardGame.player.PlayerWind;
import cardGame.utils.Constants;

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
        if (sPlayer1) {
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
            p = new PlayerFire(Constants.FIRE_TYPE);
        } else if (v < 4 && h == 0) {
            p = new PlayerIce(Constants.ICE_TYPE);
        } else if (v < 2 && h == 2) {
            p = new PlayerEarth(Constants.EARTH_TYPE);
        } else {
            p = new PlayerWind(Constants.WIND_TYPE);
        }
        if (sPlayer1) {
            player1 = p;
            sPlayer1 = false;
            show();
        } else {
            player2 = p;
            ui.setScreen(new CardSelectionScreen(ui, player1, player2));
        }

    }

    @Override
    public void hide() {
<<<<<<< Updated upstream

=======
        ui.setScreen(new CardSelectionScreen(ui));
>>>>>>> Stashed changes
    }
}

package cardGame.screens;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import cardGame.Game;
import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Card;
import cardGame.cards.Meme;

public class GameScreen implements Screen {
    private MemeStoneUI ui;
    private Game game;
    private int selectedH = -1;
    private int selectedV = -1;

    public GameScreen(MemeStoneUI ui, Player player, Player enemy) {
        this.ui = ui;
        game = ui.getGame();
        game.setPlayer(player);
        game.setEnemy(enemy);
        game.init();
    }

    @Override
    public void show() {
        ui.configureGrid(3, 8, 0, 0, 0);
		ui.setImageOnCell(2,0,"mana_4");
        //hola
        drawHand();
        drawArena(game.getPlayer(), 1);
        drawArena(game.getEnemy(), 0);
        drawOther();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCellPressed(int v, int h) {
        if (v == 0 && h == 7) {
            ui.setScreen(new MenuScreen(ui, false, this));
        } else if (v == 1 && h == 0) {
            //ui.setScreen(new CardPreviewScreen(ui,this,));
        } else if (v == 1 && h == 7) {
            game.nextTurn();
        } else if (v != 2 && h != 0) {
            selectedH = h;
            selectedV = v;
        }
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    public void drawHand() {
        List<Card> hand = game.getPlayer().getHand();
        int index = 1;
        for (Card c : hand) {
            ui.setImageOnCell(2, index, c.image());
            index++;
        }
        drawBackground(2, index, 6);
    }

    public void drawArena(Player player, int row) {
        List<Meme> arena = player.getArena();
        int index = 1;
        for (Meme m : arena) {
            ui.setImageOnCell(1, index, m.image());
            index++;
        }
        drawBackground(row, index, 6);
    }

    public void drawOther() {
        ui.setImageOnCell(0, 0, game.getEnemy().image());
        ui.setImageOnCell(2, 7, game.getPlayer().image());
        ui.setImageOnCell(1, 0, "show");
        ui.setImageOnCell(0, 7, "menu");
        ui.setImageOnCell(1, 7, "end");
    }

    public void drawBackground(int row, int start, int end) {
        for (int i = start; i <= end; i++) {
            ui.setImageOnCell(row, i, "fondo_v");
        }
    }
}

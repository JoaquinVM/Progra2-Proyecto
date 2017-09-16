package cardGame.screens;

import java.util.List;

import cardGame.Constants;
import cardGame.Game;
import cardGame.MemeStoneUI;
import cardGame.player.Player;
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
        ui.setImageOnCell(2, 0, "red_4");
        drawHand();
        drawArena(game.getPlayer(), 1);
        drawArena(game.getEnemy(), 0);
        drawOther();
    }

    @Override
    public void onCellPressed(int v, int h) {
        if (v == 0 && h == 7) {
            //Menu
            ui.setScreen(new MenuScreen(ui, false, this));
        } else if (v == 1 && h == 7) {
            //next turn
            game.nextTurn();
            drawHand();
            drawArena(game.getEnemy(), 0);
            drawArena(game.getPlayer(), 1);
            drawOther();

        } else if (v == 1 && h == 0) {
            //Show
            if (selectedV == 0 && selectedH == 0) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getEnemy().getPowerImage()));
            } else if (selectedV == 2 && selectedH == 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getPowerImage()));
            } else if (selectedV == 0 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getEnemy().getArena().get(selectedH - 1).image()));
            } else if (selectedV == 1 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getArena().get(selectedH - 1).image()));
            } else if(selectedV == 0 && selectedH > 0 && selectedH < 7){
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getHand().get(selectedH - 1).image()));
            }
        }else if(selectedH != -1 && selectedV != -1){
            selectedH = h;
            selectedV = v;
        }else{
            if(selectedV == 2 && v == 1){
                Card c = game.getPlayer().getHand().get(h + 1);
                if(c instanceof Meme && game.getPlayer().getArena().size() <= Constants.MAX_CARDS_PER_ROW){
                    game.summon((Meme) c);
                }
                c.ability();


            }



            selectedH = -1;
            selectedV = -1;
        }
    }

    public void drawHand() {
        List<Card> hand = game.getPlayer().getHand();
        int index = 1;
        for (Card c : hand) {
            ui.setImageOnCell(2, index, c.image());
            index++;
        }
        drawBackground(2, index);
    }

    public void drawArena(Player player, int row) {
        List<Meme> arena = player.getArena();
        int index = 1;
        for (Meme m : arena) {
            ui.setImageOnCell(1, index, m.image());
            index++;
        }
        drawBackground(row, index);
    }

    public void drawOther() {
        ui.setImageOnCell(0, 0, game.getEnemy().image());
        ui.setImageOnCell(2, 7, game.getPlayer().image());
        ui.setImageOnCell(1, 0, "show");
        ui.setImageOnCell(0, 7, "menu");
        ui.setImageOnCell(1, 7, "end");

        String s = "blue";
        if (selectedV == 1 && game.getPlayer().getArena().get(selectedH - 1).canAttack()) {
            s = "red";
        }
        ui.setImageOnCell(2, 0, s + "_" + game.getPlayer().getMana());
    }

    public void drawBackground(int row, int start) {
        for (int i = start; i <= Constants.MAX_CARDS_PER_ROW; i++) {
            ui.setImageOnCell(row, i, "fondo_v");
        }
    }

}

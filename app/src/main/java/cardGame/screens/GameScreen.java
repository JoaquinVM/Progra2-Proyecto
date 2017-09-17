package cardGame.screens;

import java.util.List;
import cardGame.Constants;
import cardGame.Damagable;
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
    private boolean waiting = false;

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
    public void onCellPressed(int v, int h){

        if(v == 1 && h == 0){
            if (selectedV == 0 && selectedH == 0) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getEnemy().getPowerImage()));
            } else if (selectedV == 2 && selectedH == 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getPowerImage()));
            } else if (selectedV == 0 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getEnemy().getArena().get(selectedH - 1).image()));
            } else if (selectedV == 1 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getArena().get(selectedH - 1).image()));
            } else if (selectedV == 0 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getHand().get(selectedH - 1).image()));
            }
        }else if(v == 0 && h == 7){
            ui.setScreen(new MenuScreen(ui, false, this));
        }else if( v == 7 && h == 7){
            game.nextTurn();
        }else if(!waiting && v == 1 && h > 0 && h < 7){
            Card c = game.getPlayer().getHand().get(h + 1);
            waiting = true;
        }else if(waiting && v == 0){
            Card c  = game.getPlayer().getHand().get(h + 1);
            Damagable enemy =  game.getEnemy().getArena().get(h + 1);
            Meme enemyMeme = (Meme) enemy;
            if(c.isSelectMeme()){
                c.ability(enemyMeme);
            }
            if(c.isSelectDamagable()){
                c.ability(enemy);
            }
            selectedH = -1;
            selectedV = -1;
        }
    }



    public void onCellPressed1(int v, int h) {
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
            } else if (selectedV == 0 && selectedH > 0 && selectedH < 7) {
                ui.setScreen(new CardPreviewScreen(ui, this, game.getPlayer().getHand().get(selectedH - 1).image()));
            }
        } else if (selectedH != -1 && selectedV != -1) {
            selectedH = h;
            selectedV = v;
        } else if (v == 2) {
            Card c = game.getPlayer().getHand().get(h + 1);
            if (!(c instanceof Meme) && c.isSelectMeme()) {
                waiting = true;
            } else {
                c.ability();
            }
        } else if (!waiting && selectedV == 2 && v == 1) {
            //Summon
            Card c = game.getPlayer().getHand().get(h + 1);
            if (c instanceof Meme && game.getPlayer().getArena().size() <= Constants.MAX_CARDS_PER_ROW) {
                game.summon((Meme) c);
            } else if (selectedV == 1 && v == 0) {
                //Attack
                Meme m = game.getPlayer().getArena().get(h + 1);
                Meme enemy = game.getPlayer().getArena().get(h + 1);
                if (m.canAttack()) {
                    boolean taunt = false;
                    for (int i = 0; i < game.getEnemy().getArena().size() && !taunt; i++) {
                        taunt = game.getEnemy().getArena().get(i).isTaunt();
                    }
                    if (taunt && game.getEnemy().getArena().get(h + 1).isTaunt()) {
                        game.fight(m, enemy);
                    } else if (!taunt) {
                        game.fight(m, enemy);
                    }
                }
                selectedH = -1;
                selectedV = -1;
            }
        } else if (waiting && v == 0 && h == 0) {
            //s
            Card c = game.getPlayer().getHand().get(selectedH + 1);
            if (c.isSelectDamagable()) {
                c.ability(game.getEnemy());
            }
        } else if (waiting && v == 0 && v > 0 && v < 7) {
            Card c = game.getPlayer().getHand().get(selectedH + 1);
            Meme enemy = game.getPlayer().getArena().get(h + 1);
            if (c.isSelectDamagable()) {
                Damagable d = enemy;
                c.ability(d);
            } else if (!c.isSelectDamagable() && c.isSelectMeme()) {
                c.ability(enemy);
            }
            waiting = false;
            selectedH = -1;
            selectedV = -1;
        }
    }

    public void drawHand() {
        List<Card> hand = game.getPlayer().getHand();
        int index = 1;
        for (Card c : hand) {
            ui.setImageOnCell(2, index, c.image());
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

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
    private boolean waitingSelect = false;
    private boolean waitingPlace = false;
    private boolean waitingAttack = false;
    private boolean waitingCast = false;

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
        drawBoard();
    }

    @Override
    public void onCellPressed(int v, int h){
        if(v == 1 && h == 0 && selectedH != -1 && selectedV != -1){
            //show
            String image;
            if(selectedV == 0){
                if(selectedH == 0){
                    image = game.getEnemy().getPowerImage();
                }else{
                    image =  game.getEnemy().getArena().get(selectedH - 1).image();
                }
            }else if(selectedV == 1){
                image = game.getPlayer().getArena().get(selectedH - 1).image();
            }else{
                if(selectedH == 7){
                    image = game.getPlayer().getPowerImage();
                }else{
                    image = game.getPlayer().getArena().get(selectedH - 1).image();
                }
            }
            ui.setScreen(new CardPreviewScreen(ui, this, image));

        }else if(v == 0 && h == 7){
            //Menu
            ui.setScreen(new MenuScreen(ui, false, this));
        }else if( v == 1 && h == 7){
            //next turn
            game.nextTurn();
            drawBoard();
        }else if(waitingAttack && v == 0){
            //Attack
            waitingAttack = false;
            Damagable d = game.getEnemy();
            if(h == 0){
                d = game.getEnemy();
            }else if(h - 1 < game.getEnemy().getArena().size()){
                d = game.getEnemy().getArena().get(h - 1);
            }
            game.fight(game.getPlayer().getArena().get(selectedH - 1), d);
            game.getPlayer().getArena().get(selectedH - 1).setCanAttack(false);
            drawPlayers();
        }else if(waitingPlace && v == 1 && game.getPlayer().getHand().size() < Constants.MAX_CARDS_PER_ROW){
            //Summon
            waitingPlace = false;
            game.getPlayer().getHand().get(selectedH - 1).ability();
            if(game.getPlayer().getHand().get(selectedH - 1) instanceof Meme) {
                Meme m = (Meme) game.getPlayer().getHand().get(selectedH - 1);
                game.getPlayer().getArena().add(m);
            }
            game.getPlayer().getHand().remove(selectedH - 1);
            for(Meme m : game.getPlayer().getArena()){
                if(m.getHealth() <= 0){
                    game.getPlayer().getArena().remove(m);
                }
            }
            for(Meme m : game.getEnemy().getArena()){
                if(m.getHealth() <= 0){
                    game.getEnemy().getArena().remove(m);
                }
            }
            drawBoard();
        }else if(waitingSelect && v == 0 && game.getPlayer().getHand().get(selectedH - 1).isSelectDamagable()){
            waitingSelect = false;
            Damagable d;
            if(h == 0){
                d = game.getPlayer();
            }else{
                d = game.getEnemy().getArena().get(h - 1);
            }
            game.getPlayer().getHand().get(selectedH - 1).ability(d);
        }else if(waitingSelect && v == 0 && game.getPlayer().getHand().get(selectedH - 1).isSelectMeme() && h > 0){
            waitingSelect = false;
            Meme enemy = game.getEnemy().getArena().get(h - 1);
            game.getPlayer().getHand().get(selectedH - 1).ability(enemy);
        } else{
            if(h > 0 && h < 7){
                if(v == 2 && h - 1 < game.getPlayer().getHand().size()){
                    Card c = game.getPlayer().getHand().get(h - 1);


                    if(c.isSelectDamagable() || c.isSelectMeme()){
                        waitingSelect = true;
                    }else{
                        waitingPlace = true;
                    }
                }else if(v == 1){
                    if(h - 1 < game.getPlayer().getArena().size() && game.getPlayer().getArena().get(h - 1).canAttack()){
                        drawMana(false);
                        waitingAttack = true;
                    }else if(!game.getPlayer().getArena().get(h - 1).canAttack()){
                        drawMana(true);
                    }
                }
            }
            if((v != 2 || h != 0) && ((v == 0 && h - 1 < game.getPlayer().getArena().size()) ||
                    (v == 1 && h - 1 < game.getPlayer().getArena().size()) ||
                    (v == 2 && h - 1 < game.getPlayer().getHand().size()))){
                selectedH = h;
                selectedV = v;
            }
        }
    }



    public void drawPlayers(){
        drawArena(game.getPlayer(), 1);
        drawArena(game.getEnemy(), 0);
        ui.setImageOnCell(0, 0, game.getEnemy().image());
        ui.setImageOnCell(2, 7, game.getPlayer().image());
    }

    public void drawSide(){
        drawArena(game.getPlayer(), 1);
        drawHand();
    }

    public void drawBoard(){
        drawPlayers();
        drawHand();
        drawOther();
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
            ui.setImageOnCell(row, index, m.image());
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

        drawMana(true);
    }

    public void drawBackground(int row, int start) {
        for (int i = start; i <= Constants.MAX_CARDS_PER_ROW; i++) {
            ui.setImageOnCell(row, i, "fondo_v");
        }
    }

    public void drawMana(boolean blue){
        String s = "blue";
        if(!blue){
            s = "red";
        }
        ui.setImageOnCell(2, 0, s + "_" + game.getPlayer().getMana());
    }

}

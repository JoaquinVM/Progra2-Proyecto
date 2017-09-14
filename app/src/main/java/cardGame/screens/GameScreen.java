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
		game.setPlayer(enemy);
		game.init();
	}

	@Override
	public void show() {
		ui.configureGrid(3, 8, 0, 0, 0);
		drawHand();
		drawArena(game.getPlayer());
		drawArena(game.getEnemy());
		drawOther();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCellPressed(int v, int h) {
		if(v == 0 && h == 7){
			game.nextTurn();
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public void drawHand(){
		List<Card> hand = game.getPlayer().getHand();
		int index = 0;
		for (Card c : hand){
			ui.setImageOnCell(2, index, c.image());
			index++;
		}

	}

	public void drawArena(Player player){
		List<Meme> arena = player.getArena();
		int index = 0;
		for(Meme m : arena){
			ui.setImageOnCell(1, index, m.image());
		}
	}

	public void drawOther(){
		ui.setImageOnCell(0, 0, game.getEnemy().image());
		ui.setImageOnCell(2, 7, game.getPlayer().image());
		ui.setImageOnCell(1, 7, "show");
	}
}

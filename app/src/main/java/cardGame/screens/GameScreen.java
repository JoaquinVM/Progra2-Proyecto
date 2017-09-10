package cardGame.screens;

import java.util.Stack;

import cardGame.Game;
import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Meme;

public class GameScreen implements Screen {
	private MemeStoneUI ui;
	private Screen sc;
	private Game game;
	private Player player;
	private Player enemy;
	public GameScreen(MemeStoneUI ui, Player player, Player enemy) {
		this.ui = ui;
		this.player = player;
		this.enemy = enemy;
	}




	public GameScreen(Player p1, Player p2){
		//TODO improve constructor
	}

	@Override
	public void show() {
	//	ui.setImageOnCell(0,0,p1);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCellPressed(int v, int h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


}

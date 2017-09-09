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
	private Player player1;
	private Player player2;
	public GameScreen(MemeStoneUI ui) {
		this.ui = ui;
	}


	public void setPlayer1(Player player1){
		this.player1=player1;
	}
	public void setPlayer2(Player player2){
		this.player2=player2;
	}
	public void setScreen(Screen sc){
		this.sc=sc;
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

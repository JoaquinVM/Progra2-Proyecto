package cardGame.screens;

import cardGame.MemeStoneUI;
import cardGame.player.Player;
import cardGame.cards.Deck;

/**
 * Created by joaquin on 9/16/17.
 */

public class DeckModeScreen implements Screen {

    private MemeStoneUI ui;
    private Player player1;
    private Player player2;

    public DeckModeScreen(MemeStoneUI ui, Player player1, Player player2) {
        this.ui = ui;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void show() {
        ui.configureGrid(1, 2, 0, 0, 0);
        ui.setImageOnCell(0, 0, "random_deck");
        ui.setImageOnCell(0, 1, "build_deck");
    }

    @Override
    public void onCellPressed(int v, int h) {
        if(h == 0){
            player1.setDeck(Deck.randomDeck());
            player2.setDeck(Deck.randomDeck());
            ui.setScreen(new GameScreen(ui, player1, player2));
        }else if(h == 1){
            ui.setScreen(new CardSelectionScreen(ui, player1, player2));
        }

    }

}

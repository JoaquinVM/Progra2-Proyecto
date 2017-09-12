package cardGame.screens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cardGame.MemeStoneUI;
import cardGame.Player;
import cardGame.cards.Card;
import cardGame.cards.CardDatabase;
import cardGame.cards.Meme;

/**
 * Created by Joaco99 on 12/09/2017.
 */

public class CardSelectionScreen implements Screen {

    private MemeStoneUI ui;
    private Player player1;
    private Player player2;
    private List<Card> cards = new LinkedList<>();
    private int page = 0;
    private int selectedV = -1;
    private int selecteH = -1;

    public CardSelectionScreen(MemeStoneUI ui, Player player1, Player player2) {
        this.ui = ui;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void show() {
        cards.addAll(CardDatabase.getInstance().getSpells());
        cards.addAll(CardDatabase.getInstance().getMemes());

        //Arrays.sort(cards);



    }

    @Override
    public void update() {

    }

    @Override
    public void onCellPressed(int v, int h) {

    }

    @Override
    public void hide() {

    }
}

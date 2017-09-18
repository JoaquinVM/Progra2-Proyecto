package cardGame;

import cardGame.cards.CardDatabase;
import cardGame.screens.MenuScreen;
import cardGame.screens.PlayerSelectionScreen;
import cardGame.screens.Screen;
import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class MemeStoneUI implements UI {

    AndroidGameGUI gui;

    Screen screen ;

    Game game;

    public MemeStoneUI(AndroidGameGUI gui) {
        this.gui = gui;
    }

    @Override
    public void onButtonPressed(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        screen.onCellPressed(vertical, horizontal);
    }

    @Override
    public void initialiseInterface() {
        gui.setBottomSectionProportion(0);
        setScreen(new MenuScreen(this, true, null));
    }

    public void newGame(){
        game = new Game();
        CardDatabase.getInstance().setGame(game);
        setScreen(new PlayerSelectionScreen(this));
    }

    public void configureGrid(int numberOfRows, int numberOfColumns, int verticalSpacing, int horizontalSpacing, int textSize) {
        gui.configureGrid(numberOfRows, numberOfColumns, verticalSpacing, horizontalSpacing, textSize);
    }

    public void setImageOnCell(int vertical, int horizontal, String image) {
        gui.setImageOnCell(vertical, horizontal, image);
    }

    public void setScreen(Screen screen){
        this.screen = screen;
        this.screen.show();
    }

    public Game getGame() {
        return game;
    }
}

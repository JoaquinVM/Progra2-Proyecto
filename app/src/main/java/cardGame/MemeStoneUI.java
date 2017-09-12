package cardGame;
import cardGame.cards.CardDatabase;
import cardGame.player.PlayerEarth;
import cardGame.player.PlayerFire;
import cardGame.screens.CardSelectionScreen1;
import cardGame.screens.MenuScreen;
import cardGame.screens.PlayerSelectionScreen;
import cardGame.screens.Screen;
import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class MemeStoneUI implements UI {

    AndroidGameGUI gui;

    Screen screen ;

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
        setScreen(new MenuScreen(this));
    }

    public void newGame(){
        Game game = new Game(this);
        CardDatabase.getInstance().initMemes(game);
        CardDatabase.getInstance().initSpells(game);
        setScreen(new PlayerSelectionScreen(this));
    }

    public void configureGrid(int numberOfRows, int numberOfColumns, int verticalSpacing, int horizontalSpacing, int textSize) {
        gui.configureGrid(numberOfRows, numberOfColumns, verticalSpacing, horizontalSpacing, textSize);
    }

    public void setImageOnCell(int vertical, int horizontal, String image) {
        gui.setImageOnCell(vertical, horizontal, image);
    }

    public void setScreen(Screen screen){
        if(this.screen != null){
            this.screen.hide();
        }
        this.screen = screen;
        this.screen.show();
    }
}

package cardGame;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class MemeStoneUI implements UI{

	AndroidGameGUI gui;
	public MemeStoneUI(AndroidGameGUI gui) {
		this.gui = gui;
	}
	@Override
	public void onButtonPressed(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCellPressed(int vertical, int horizontal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialiseInterface() {
		configureGrid(3, 8, 1, 1, 0);
		for(int i = 0; i < 3; i++){

			for(int j = 0; j < 8; j++){
				gui.setImageOnCell(i, j, "fondo");
			}
		}
		//jvhvbhjbvjfutufuff
		
	}
	
	public void configureGrid(int numberOfRows, int numberOfColumns, int verticalSpacing, int horizontalSpacing, int textSize){
		gui.configureGrid(numberOfRows, numberOfColumns, verticalSpacing, horizontalSpacing, textSize);
	}
	
	public void setImageOnCell(int vertical, int horizontal, String image){
		gui.setImageOnCell(vertical, horizontal, image);
	}
}

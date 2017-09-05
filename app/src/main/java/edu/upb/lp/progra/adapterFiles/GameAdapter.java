package edu.upb.lp.progra.adapterFiles;

import cardGame.MemeStoneUI;


/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 */
public class GameAdapter {
	public static UI selectGame(AndroidGameGUI gui) {
		return new MemeStoneUI(gui);
	}	
}

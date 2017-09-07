package cardGame.screens;

						public interface Screen {
	
	void show();
	
	void update();
	
	void onCellPressed(int v, int h);

	void hide();

	
}

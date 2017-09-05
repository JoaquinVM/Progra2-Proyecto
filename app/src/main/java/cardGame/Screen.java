package cardGame;

public interface Screen {
	
	public void show();
	
	public void update();
	
	public void onCellPressed(int v, int h);

	public void hide();
//jfnehanf
}
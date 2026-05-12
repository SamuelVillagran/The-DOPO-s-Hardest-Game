package domain;

public class Bomb extends DinamicTile {

	
	public Bomb(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		return 15;
	}

	@Override
	public int getHeight() {
		return 15;
	}

}

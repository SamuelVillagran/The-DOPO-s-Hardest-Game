package domain;

public class Bomb extends DinamicTile {

	
	public Bomb(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public Bomb() {
		
	}

	@Override
	public String getPathImage() {
		return getNameSuperClass()+"/"+getNameClass()+".png";
	}

	@Override
	public String getNameClass() {
		return getClass().getSimpleName();
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

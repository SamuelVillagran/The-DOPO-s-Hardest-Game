package domain;

public abstract class Element implements GetInformation {

	protected int posX, posY;

	public abstract String getPathImage();
	public abstract String getNameClass();
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
}

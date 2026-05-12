package domain;

public abstract class Element implements HitBox{

	protected int posX, posY;
	protected float size;
	
	public abstract String getPathImage();
	public abstract String getNameClass();
	
	public Element() {
		size = 1;
	}
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public float getSize() {
		return size;
	}
}

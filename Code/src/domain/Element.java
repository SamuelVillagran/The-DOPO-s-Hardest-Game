package domain;

import java.awt.image.BufferedImageOp;

public abstract class Element {

	protected int posX, posY;
	protected String color;
	public abstract String getPathImage();
	public abstract String getNameClass();
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
}

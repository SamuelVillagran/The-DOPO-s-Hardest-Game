package domain;

public abstract class Entity extends Element {

	protected int speed;
	
	public abstract void move(char direction);
	
}

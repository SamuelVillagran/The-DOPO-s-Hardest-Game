package domain;

public abstract class Entity extends Element {

	protected int speed;
	protected StateEntity state;
	
	public abstract void move(char direction);
	
}

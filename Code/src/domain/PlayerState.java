package domain;

public abstract class PlayerState implements StateEntity {

	private Player py;
	
	public abstract void setAttributesPlayer();
	public void setPlayer(Player py) {
		this.py = py;
	}
}

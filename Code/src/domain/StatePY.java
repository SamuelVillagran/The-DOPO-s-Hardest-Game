package domain;

public abstract class StatePY implements StateEntity {

	private Player py;
	
	public abstract void setAttributesPlayer();
	public void setPlayer(Player py) {
		this.py = py;
	}
}

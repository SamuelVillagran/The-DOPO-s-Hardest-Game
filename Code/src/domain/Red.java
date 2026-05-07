package domain;

public class Red extends PlayerState {

	private Player py;
	
	@Override
	public void setAttributesPlayer() {
		py.setAttributesPlayer(
				100, 100, 4, "red");
		
	}

	@Override
	public void setPlayer(Player py) {
		this.py = py;
	}	
}

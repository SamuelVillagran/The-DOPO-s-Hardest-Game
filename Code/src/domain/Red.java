package domain;

public class Red extends PlayerState {
	
	public Red(Player py) {
		super(py);
	}

	@Override
	public int getSpeed() {
		return 2;
	}

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return 32;
	}

	@Override
	public void onEnemyContact() {
		py.setState(new DeadState(py));
		
	}
	
}

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
		return 36;
	}

	@Override
	public int getHeight() {
		return 36;
	}

	@Override
	public void onEnemyContact() {
		py.setState(new DeadState(py));
		
	}
	
}

package domain;

public class Green extends PlayerState{

	public Green(Player py) {
		super(py);
	}

	@Override
	public int getSpeed() {
		return py.getBaseSpeed();
	}

	@Override
	public int getWidth() {
		return 32;
	}

	@Override
	public int getHeight() {
		return 32;
	}

	@Override
	public void onEnemyContact() {
		py.setState(new SlowedState(py));
		
	}

}

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
		return 30;
	}

	@Override
	public int getHeight() {
		return 30;
	}

	@Override
	public void onEnemyContact() {
		py.setState(new SlowedState(py));
		
	}

}

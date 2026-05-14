package domain;

public class SlowedState extends PlayerState{

	public SlowedState(Player py) {
		super(py);
	}

	@Override
	public int getSpeed() {
		return (int) (py.getBaseSpeed() * 0.7f);
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
		py.setState(new DeadState(py));
		
	}
	
	

}

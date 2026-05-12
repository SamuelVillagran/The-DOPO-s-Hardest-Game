package domain;

public class DeadState extends PlayerState {

	public DeadState(Player py) {
		super(py);
	}

	@Override
	public int getSpeed() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void onEnemyContact() {
	}
	
	@Override
	public boolean isDead() {
		return true;
	}

}

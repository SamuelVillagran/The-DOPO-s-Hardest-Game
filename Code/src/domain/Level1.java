package domain;

public class Level1 extends Level {

	
	
	public Level1() {
		initialize();
		map = new Map(1);
	}

	@Override
	public void initialize() {
		elements.put(elements.size(), new Obstacle());
		elements.put(elements.size(), new Coin());
		elements.put(elements.size(), new Floor());
		elements.put(elements.size(), new Enemy());
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

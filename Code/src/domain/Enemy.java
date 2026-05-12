package domain;

public class Enemy extends Entity {

	public Enemy() {
		posX = 210;
		posY = 210;
		size = 0.5f;
		state = (StateEnemy) new Basic();
		((StateEnemy) state).setEnemy(this);
	}
	
	public Enemy(int x, int y) {
		size = 0.5f;
		posX = x; posY = y;
		state = (StateEnemy) new Basic();
		((StateEnemy) state).setEnemy(this);
	}
	
	@Override
	public void move(char direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPathImage() {
		return "/enemy/blue.png";
	}

	@Override
	public int getWidth() {
		return 32;
	}

	@Override
	public int getHeight() {
		return 32;
	}

	

	
	
}

package domain;

public class Enemy extends Entity {

	public Enemy() {
		posX = 210;
		posY = 210;
		size = 0.5f;
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

	

	
	
}

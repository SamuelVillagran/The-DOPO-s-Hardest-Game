package domain;

public class Player extends Entity {

	private int countBall;
	private int deaths;
	private int live;
	private int nCurrentMap;
	
	public Player() {

		setAttributesPlayer(100, 100, 2, "");
		state = new Red();
		((StatePY) state).setPlayer(this);
	}
	
	/**
	 * This method decrement player's Y position.
	 * Decrement the magnitude of parameter given.
	 * @param decrement decrement is the units of player's
	 * Y Position that going to decrement
	 */
	public void decrementPosY(int decrement) {
		posY -= decrement;
	}
	
	/**
	 * This method decrement player's X position.
	 * Decrement the magnitude of parameter given.
	 * @param decrement decrement is the units of player's
	 * X Position that going to decrement
	 */
	public void decrementPosX(int decrement) {
		posX -= decrement;
	}
	
	/**
	 * This method increment player's Y position.
	 * Increment the magnitude of parameter given.
	 * @param increment increment is the units of player's
	 * Y Position that going to increment
	 */
	public void incrementPosY(int increment) {
		posY += increment;
	}
	
	/**
	 * This method increment player's X position.
	 * Increment the magnitude of parameter given.
	 * @param decrement increment is the units of player's
	 * X Position that going to increment
	 */
	public void incrementPosX(int increment) {
		posX += increment;
	}
	
	/**
	 * This method decrement player's Y position.
	 * This method decrement player's X position.
	 * Decrement the magnitude of player speed.
	 */
	public void decrementSpeedPosY() {
		posY -= speed;
	}
	
	/**
	 * This method decrement player's X position.
	 * Decrement the magnitude of player speed.
	 */
	public void decrementSpeedPosX() {
		posX -= speed;
	}
	
	/**
	 * This method increment player's Y position.
	 * Increment the magnitude of player speed
	 */
	public void incrementSpeedPosY() {
		posY += speed;
	}
	
	/**
	 * This method increment player's X position.
	 * Increment the magnitude of player speed.
	 */
	public void incrementSpeedPosX() {
		posX += speed;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setAttributesPlayer(int x, int y, int speed, String color) {
		posX = x;
		posY = y;
		this.speed = speed;
		
	}
	
	public void setState(StatePY statePY) {
		this.state = statePY;
		statePY.setPlayer(this);
		statePY.setAttributesPlayer();
	}
	
	public String getNameClass() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getNameState() {
		return state.getClass().getSimpleName().toLowerCase();
	}
	
	public String getPathImage() {
		return "/"+getNameClass()+"/"+getNameState()+".png";		
	}

	public void move(char direction) {
		switch (direction) {
			case 'u': posY -= speed;
				break;
			case 'd': posY += speed;
				break;
			case 'l': posX -= speed;
				break;
			case 'r': posX += speed;
				break;
		}
	}

}

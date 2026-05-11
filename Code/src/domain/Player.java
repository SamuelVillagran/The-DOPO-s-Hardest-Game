package domain;

public class Player extends Entity implements Collisionable{

	private int countBall;
	private int deaths;
	protected PlayerState state;
	
	/**
	 * 
	 * @param type
	 * @throws HardestGameException
	 */
	public Player(PlayerType type) throws HardestGameException {
		deaths = 0;
		countBall = 0;
		//setAttributesPlayer(75, 75, 2, "");
		this.state = createInitialState(type);
		//((PlayerState) state).setPlayer(this);
		size = 0.5f;
	}
	
	private PlayerState createInitialState(PlayerType type) throws HardestGameException {
		switch (type){
		case RED : return new Red(this);
		//case BLUE : return new Blue(this);
		//case GREEN : return new Green(this);
		default : throw new HardestGameException(HardestGameException.PLAYER_TYPE_UNKNOWN); 
		}
	}
	
	public Player(int x, int y) {
		deaths = 0;
		countBall = 0;
		//setAttributesPlayer(x, y, 2, "");
		state = new Red(this);
		//((PlayerState) state).setPlayer(this);
		size = 0.5f;
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

	public void setAttributesPlayer(int x, int y, int speed) {
		posX = x;
		posY = y;
		this.speed = speed;
		
	}
	
	/**
	 * Change the state of the Player
	 * @param statePY the new state wished: it could be Slowed or Dead.
	 */
	public void setState(PlayerState statePY) {
		this.state = statePY;
	}

	/**
	 * Makes move the player of game
	 * @param direction direction is where going to move the player
	 */
	public void move(char direction) {
		switch (direction) {
			case 'u': posY -= state.getSpeed();
				break;
			case 'd': posY += state.getSpeed();
				break;
			case 'l': posX -= state.getSpeed();
				break;
			case 'r': posX += state.getSpeed();
				break;
		}
	}
	
	/**
	 * Check if the player is dead.
	 * @return
	 */
	public boolean isDead() {
		return state.isDead();
	}
	
	@Override
	public int getWidth() {
		return state.getWidth();
	}
	
	@Override
	public int getHeight() {
		return state.getHeight();
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}

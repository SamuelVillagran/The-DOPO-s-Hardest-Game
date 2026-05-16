package domain;

public class Player extends Entity implements HitBox, Movable{

	private int countBall;
	private int deaths;
	protected String name;
	protected int baseSpeed;
	//protected PlayerState state;
	
	/**
	 * 
	 * @param type
	 * @throws HardestGameException
	 */
	public Player(PlayerType type, String name) throws HardestGameException {
		deaths = 0;
		countBall = 0;
		setAttributesPlayer(75, 75);
		this.state = createInitialState(type);
		this.name = name;
		//((PlayerState) state).setPlayer(this);
		baseSpeed = 3;
		size = 0.5f;
	} 
	
	private PlayerState createInitialState(PlayerType type) throws HardestGameException {
		switch (type){
		case RED : return new Red(this);
		case BLUE : return new Blue(this);
		case GREEN : return new Green(this);
		default : throw new HardestGameException(HardestGameException.PLAYER_TYPE_UNKNOWN); 
		}
	}
	
	public Player(int x, int y) {
		deaths = 0;
		countBall = 0;
		setAttributesPlayer(x, y);
		state = new Red(this);
		//((PlayerState) state).setPlayer(this);
		size = 0.5f;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setAttributesPlayer(int x, int y) {
		posX = x;
		posY = y;
		
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
		int speed = getPlayerState().getSpeed();
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
	
	public void move(char direction, CollisionContext context, CollisionChecker checker) {
		int speed = getPlayerState().getSpeed();;
		
		int nextX = posX;
		int nextY = posY;
		
		switch (direction) {
		case 'u': nextY -= speed;
			break;
		case 'd': nextY += speed;
			break;
		case 'l': nextX -= speed;
			break;
		case 'r': nextX += speed;
			break;
		default: 
			return;
		}
		
		if (!checker.canMove(this, nextX, nextY, context)) return;
		
		posX = nextX;
		posY = nextY;
	}
	
	
	/**
	 * Check if the player is dead.
	 * @return
	 */
	public boolean isDead() {
		return getPlayerState().isDead();
	}
	
	@Override
	public int getWidth() {
		return getPlayerState().getWidth();
	}
	
	@Override
	public int getHeight() {
		return getPlayerState().getHeight();
	}
	
	public int getBaseSpeed() {
		return baseSpeed;
	}
	public String getName() {
		return name;
	}
	
	public PlayerState getPlayerState() {
		return (PlayerState) state;
	}

}

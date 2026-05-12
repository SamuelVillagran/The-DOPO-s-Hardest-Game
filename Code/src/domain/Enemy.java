package domain;

import java.awt.Point;
import java.util.List;

public class Enemy extends Entity implements Solid {

	private List<Point> movement;
	
	public Enemy() {
		posX = 210;
		posY = 210;
		size = 0.5f;
		state = (StateEnemy) new Basic(this);
		speed = 3;
	}
	
	public Enemy(int x, int y) {
		size = 0.5f;
		posX = x; posY = y;
		state = (StateEnemy) new Basic(this);
	}
	
	/**
	 * Makes move the player of game
	 * @param direction direction is where going to move the player
	 */
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

	public void setPoints(List<Point> points) {
		movement = points;
	}

	
	
}

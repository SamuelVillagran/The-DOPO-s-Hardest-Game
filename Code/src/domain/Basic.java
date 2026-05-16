package domain;

import java.awt.Point;
import java.util.List;

public class Basic extends Enemy {

	private CollisionChecker cCheker;
	private CollisionContext context;
	
	public Basic(List<Point> movement) {
		super(movement);
	}
	
	public Basic(List<Point> movement, CollisionChecker cCheker) {
		super(movement);
		this.cCheker = cCheker;
	}

	public Basic(List<Point> movement, CollisionChecker cCheker, CollisionContext context) {
		super(movement);
		this.cCheker = cCheker;
		this.context = context;
		int dx2 = 0, dy2 = 0;
		Point point1 = movement.get(0);
		Point point2 = movement.get(1);
		int px1 = (int) point1.getX();
		int py1 = (int) point1.getY();
		int px2 = (int) point2.getX();
		int py2 = (int) point2.getY();
		dx2 = (posX - px2); 
		dy2 = (posY - py2); 
		
		if (posX == px1) {
			if (dx2 > 0) {
				direction = 'r';
			} else if (dx2 < 0) {
				direction = 'l';
			}
		}
		if (posY == py1) {
			if (dy2 > 0) {
				direction = 'd';
			} else if (dy2 < 0) {
				direction = 'u';
			}
		}
	}

	public void move() { 
		
		super.move(direction);
		
		int nextX = posX + speed;
        int nextY = posY + speed;
        
		int x = 0, y = 0;
		
		if (!cCheker.canMove(this, nextX, nextY, context)) {
			if (direction == 'r' || direction == 'l') {
				switch (direction) {
					case 'l' -> direction = 'r';
					case 'r' -> direction = 'l';
				}
			}
			if (direction == 'u' || direction == 'd') {
				switch (direction) {
					case 'u' -> direction = 'd';
					case 'd' -> direction = 'u';
				}
			}
		}
	}
}

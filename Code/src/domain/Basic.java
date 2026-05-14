package domain;

import java.awt.Point;
import java.util.List;

public class Basic extends Enemy {

	
	
	public Basic(List<Point> movement) {
		super(movement);
	}
	
	public void move() { 
		boolean isNextMovement = false, isVertical = false, isHorizontal = false;
		int x = 0, y = 0;
		for (Point point : movement) {
			x = (int)point.getX(); y = (int) point.getY();
			if (x==posX && point.getY() == posY) {
				isNextMovement = true;
			}
			if (isNextMovement) {
				if (posX != x) {
					isVertical = true;
				}
				if (posY != y) {
					isHorizontal = true;
				}
				break;
			}
		}
		if (isVertical) {
			if (x < posX) {
				super.move('l');
			}
			if (x > posX) {
				super.move('r');
			}
		}
		
		if (isHorizontal) {
			if (y < posY) {
				super.move('u');
			}
			if (y > posY) {
				super.move('d');
			}
		}
	}
	
}

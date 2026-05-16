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
		speed = 5;
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
		dy2 = (posY - py2); // Las condicionales y código de para abajo fue perfeccionado con Gemini IA 2026
		// 1. Si las Y son iguales, el camino es horizontal (Izquierda a Derecha)
		if (py1 == py2) {
		    if (px1 < px2) {
		        direction = 'r'; // Va a la derecha
		    } else {
		        direction = 'l'; // Va a la izquierda
		    }
		}

		// 2. Si las X son iguales, el camino es vertical (Arriba a Abajo)
		if (px1 == px2) {
		    if (py1 < py2) {
		        direction = 'd'; // Va hacia abajo
		    } else {
		        direction = 'u'; // Va hacia arriba
		    }
		}
	}

	public void move() { 
		int nextX = posX;
	    int nextY = posY;
	    switch (direction) {
	        case 'u' -> nextY -= speed;
	        case 'd' -> nextY += speed;
	        case 'l' -> nextX -= speed;
	        case 'r' -> nextX += speed;
	    }
		if (!cCheker.canMove(this, nextX, nextY, context)) {
			if (direction == 'r' || direction == 'l') {
				direction = (direction == 'r') ? 'l' : 'r';
			}
			if (direction == 'u' || direction == 'd') {
				direction = (direction == 'u') ? 'd' : 'u';
			}
		} else {
			super.move(direction);
		}
	}
}

package presentation;

import java.awt.event.KeyAdapter;

public class KeyHandler extends KeyAdapter {

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean rigth;
	
	public KeyHandler() {
		setUp(false);
		setDown(false);
		setLeft(false);
		setRigth(false);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRigth() {
		return rigth;
	}

	public void setRigth(boolean rigth) {
		this.rigth = rigth;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean getUp() {
		return up;
	}

	public boolean getDown() {
		return down;
	}
	
	public boolean getRigth() {
		return rigth;
	}
	
	public boolean getLeft() {
		return left;
	}
}

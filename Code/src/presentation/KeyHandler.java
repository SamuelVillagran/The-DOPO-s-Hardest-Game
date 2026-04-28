package presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

	private boolean up;
	private boolean down;
	private boolean left;
	private boolean rigth;
	
	public KeyHandler() {
		up = false;
		down = false;
		left = false;
		rigth = false;
	}

}

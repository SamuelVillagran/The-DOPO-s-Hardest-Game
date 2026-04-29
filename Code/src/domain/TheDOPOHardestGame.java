package domain;

import java.util.HashMap;
import java.util.HashSet;

public class TheDOPOHardestGame {

	private Map map;
	
	public TheDOPOHardestGame() {
		map = new Map();
	}

	public HashMap<Integer, Element> getElements() {
		return map.getElements();
	}

	public HashMap<String, String> getElementsToDraw() {
		return map.loadElementImage();
	}
	
	public Player getPlayer() {
		return map.getPlayer();
	}
}

package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TheDOPOHardestGame {

	private static Level currentlevel;
	private ArrayList<Player> players;
	
	public TheDOPOHardestGame() {
		players = new ArrayList<>();
		players.add(new Player());
		currentlevel = new Level1();
	}
	
	public String getPathLevel(int level, String modePlay) {
		return "/level/level"+1;
	}
	
	public HashMap<String, String> getElementsToDraw() throws IOException{
		HashMap<String, String> elementsPath = new HashMap();
		elementsPath = currentlevel.getElementsToDraw();
		Player py = getPlayer();
		elementsPath.put(py.getNameClass(), py.getPathImage());
		return elementsPath;
	}


	public Player getPlayer() {
		return players.get(0);
	}
	
	public HashMap<Integer, Element> getElements() {
		return currentlevel.getElements();
	}
}

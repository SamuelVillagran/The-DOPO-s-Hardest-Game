package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Level implements CollisionContext{
	protected static int numCoin; 
	protected LinkedHashMap<Integer, Element> elements;
	protected static Map map;
	protected List<Player> players;
	
	/* 
	 * elements = new HashMap<>();
		
		elements.put(elements.size()+1, new Obstacle());
		elements.put(elements.size()+1, new Coin());
		elements.put(elements.size()+1, new Floor());
		elements.put(0, new Player());
	 * 
	 */
	public Level() {
		numCoin = 0;
		elements = new LinkedHashMap<>();
		players = new ArrayList<>();
	}
	
	public abstract void initialize();
	public HashMap<Integer, Element> getElements() {
		return elements;
	}
	
	public abstract boolean isCompleted();
	public abstract void spawnPlayers(List<Player> pys);
	
	public HashMap<String, String> getElementsToDraw() {
		HashMap<String, String> pathsElements;
		
		pathsElements = new HashMap<String, String>();
		
		for (Element e : elements.values()) {
			String nameClass = e.getNameClass();
			if (!pathsElements.containsKey(nameClass)) {
				pathsElements.put(nameClass, e.getPathImage());
			}
		}
		return pathsElements;
		
	}

	public int[][] loadMap() {
		return map.getMapTileNum();
	}

	public int[][] getMapTileNum() {
		return map.getMapTileNum();
	}
	
	protected void registerTiles() {
		for(Tile tile : map.getTiles()) {
			elements.put(elements.size() +1, tile);
		}
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void removeElement(Element element) {
		
	}
	
	public void update(CollisionChecker checker) {
		for(Player player : players) {
			checker.checkContactsWithInteractable(player, this, this);
		}
	}

	
}

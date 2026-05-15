package domain;

import java.util.HashMap;
import java.util.List;

public abstract class Level implements CollisionContext{

	protected static int numCoin; 
	protected HashMap<Integer, Element> elements;
	protected static Map map;
	
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
		elements = new HashMap<>();
		map = new Map(1);
		registerTiles();
	}
	
	public abstract void initialize();
	public HashMap<Integer, Element> getElements() {
		return elements;
	}
	
	public abstract boolean isCompleted();
	public abstract void spawnPlayers(List<Player> pys);
	
	public HashMap<String, String> getElementsToDraw() {
		String pathImage = "";
		HashMap<String, String> pathsElements;
		
		pathsElements = new HashMap();
		
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

	
}

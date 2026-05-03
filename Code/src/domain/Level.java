package domain;

import java.util.HashMap;

public abstract class Level {

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
	}
	
	public abstract void initialize();
	public HashMap<Integer, Element> getElements() {
		return elements;
	}
	
	public abstract boolean isCompleted();
	
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
	
}

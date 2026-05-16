package domain;

import java.util.HashMap;

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
		boolean containKey = false;
		String nameClass;
		for (Element e : elements.values()) {
			nameClass = e.getNameClass();
			containKey = pathsElements.containsKey(nameClass);
			if (!containKey) {
				pathsElements.put(nameClass, e.getPathImage());
			}
		}
		return pathsElements;
		
	}

	public int[][] getMapTileNum() {
		return map.getMapTileNum();
	}
	
}

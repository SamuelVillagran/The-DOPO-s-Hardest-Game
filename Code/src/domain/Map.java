package domain;


import java.util.HashMap;
import java.util.HashSet;

public class Map {

	private HashMap<Integer, Element> elements;
	
	
	public Map() {
		elements = new HashMap<>();
		elements.put(elements.size(), new Player());
	}
	
	public HashMap<String, String> loadElementImage() {
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

	public HashMap<Integer, Element> getElements() {
		return elements;
	}

	public Player getPlayer() {
		return (Player) elements.get(0);
	}
	
}

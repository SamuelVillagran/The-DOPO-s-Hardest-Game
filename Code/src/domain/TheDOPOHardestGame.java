package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TheDOPOHardestGame {

	private static Level currentLevel;
	private ArrayList<Player> players;
	private static int numCurrentLevel;
	
	public TheDOPOHardestGame(int numCurrentLevel) { // String filePathMap como parametro
		players = new ArrayList<>();
		players.add(new Player());
		this.currentLevel = new Level1();
		this.numCurrentLevel = numCurrentLevel;
	}
	
	
	
	public HashMap<String, String> getElementsToDraw() throws IOException{
		HashMap<String, String> elementsPath = new HashMap();
		elementsPath = this.currentLevel.getElementsToDraw();
		
		//Carga las imagenes de las casillas 
		Tile[] tiles = loadTiles();
	    for (Tile t : tiles) {
	        if (t != null && !elementsPath.containsKey(t.getNameClass())) {
	            elementsPath.put(t.getNameClass(), t.getPathImage());
	        }
	    }
		
	    // Carga la imagen del jugador
		Player py = getPlayer();
		elementsPath.put(py.getNameClass(), py.getPathImage());
		return elementsPath;
	}


	public Player getPlayer() {
		return players.get(0);
	}
	
	public HashMap<Integer, Element> getElements() {
		return this.currentLevel.getElements();
	}
	
	/**
	 * Load the buffered text's map and convert it into an integer matrix. This matrix is named mapTileNum.
	 * @param filePathMap
	 */
	public int[][] loadMap() {
		return this.currentLevel.getMapTileNum();
	}
	
	
	/**
	 * Load every tile that there are at the game
	 * @return An Array of different types of tile 0: Floor, 1: Obstacle
	 */
	public Tile[] loadTiles() {
		Tile[] tiles = new Tile[10];
		tiles[0] = new Floor();
		tiles[1] = new Obstacle();
		return tiles;
	}
	
	public void movePlayers(char direction) {
		for (Player py : players) {
			py.move(direction);
		}
	}
	
	
	public void setCurrentLevel(int numLevel) {
		numCurrentLevel = numLevel;
	}
	
}

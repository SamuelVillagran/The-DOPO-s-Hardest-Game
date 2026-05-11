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
	
	/**
	 * Constructor for main class of domain TheDOPOHardestGame
	 * @param numCurrentLevel
	 */
	public TheDOPOHardestGame(int numCurrentLevel) {
		players = new ArrayList<>();
		players.add(new Player());
		this.currentLevel = new Level1();
		this.numCurrentLevel = numCurrentLevel;
	}
	
	
	/**
	 * Give elements to GUI can draw it 
	 * @return HashMap HashMap with first String with name element and second path element's file
	 * @throws IOException
	 */
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
		Player py = getPlayer1();
		elementsPath.put(py.getNameClass(), py.getPathImage());
		return elementsPath;
	}


	public Player getPlayer1() {
		return players.get(0);
	}
	
	public Player getPlayer2() {
		return players.get(1);
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
	
	
	public void createEntitys() {
		int[][] map = loadMap();
		int dimCol, dimRow;
		for (int i=0; i < DimensionGame.MAXWORLDROW; i++) {
			for (int j=0; j < DimensionGame.MAXWORLDCOL; j++) {
				if (map[i][j] == 10) {
					dimRow = i*DimensionGame.TILESIZEHEIGHT;
					dimCol = i*DimensionGame.TILESIZEWIDTH;
					Player newPlayer = new Player(dimRow, dimCol);
					players.add(newPlayer);
				}
			}
		}
	}
	
	/**
	 * Load every tile that there are at the game
	 * @return An Array of different types of tile 0: Floor, 1: Obstacle
	 */
	public Tile[] loadTiles() {
		Tile[] tiles = new Tile[11];
		tiles[0] = new Floor();
		tiles[1] = new Obstacle();
		tiles[3] = new Goal();
		return tiles;
	}
	
	/**
	 * Move every player to specific direction
	 * @param direction direction is 'l': left, 'r': right, 'u': up or 'd': down
	 */
	public void movePlayers(char direction) {
		for (Player py : players) {
			py.move(direction);
		}
	}
	
	
	public void setCurrentLevel(int numLevel) {
		numCurrentLevel = numLevel;
	}
	
}

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
	private GameMode gameMode;
	private CollisionChecker cChecker;
	private static TheDOPOHardestGame game;
	
	/**
	 * Constructor class to start game once Window is open.
	 */
	private TheDOPOHardestGame () {
		cChecker = new CollisionChecker();
	}
	
	/**
	 * Allow get instance of principal game
	 * @return The one game instance
	 */
	public static TheDOPOHardestGame getGame() {
		if (game == null) {
			game = new TheDOPOHardestGame();
		}
		return game;
	}
	
	/**
	 * Start the game with a specific characteristics.
	 * @param gameMode specific Game Mode it could take values;
	 * PlayerMode, PlaverVsMachine, PlayerVsPlayer.
	 * @param numCurrentLevel the actual number level.
	 * @throws HardestGameException
	 */
	public void startGame(GameMode gameMode, int numCurrentLevel) throws HardestGameException {
		this.gameMode = gameMode;
		this.numCurrentLevel = numCurrentLevel; 
		players = new ArrayList<>();
		Player py = new Player(PlayerType.RED, "Raul");
		players.add(py);
		this.currentLevel = new Level1();
		this.numCurrentLevel = numCurrentLevel;
		((Level1) currentLevel).spawnPlayers(players);
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
	
	/**
	 * Load every tile that there are at the game
	 * @return An Array of different types of tile 0: Floor, 1: Obstacle
	 */
	public Tile[] loadTiles() {
		Tile[] tiles = new Tile[11];
		tiles[0] = new Floor();
		tiles[1] = new Obstacle();
		tiles[2] = new GreenTile();
		tiles[3] = new Bomb();
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

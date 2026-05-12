package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import domain.DimensionGame;
import domain.Element;
import domain.GameMode;
import domain.HardestGameException;
import domain.TheDOPOHardestGame;
import domain.Tile;

public class TheDOPOHardestGameGUI extends JPanel implements Runnable {

	private static BufferedImage imageTitleScreen;

	private KeyHandler keyH;
	private Thread gameThread;
	private TheDOPOHardestGame game;
	private HashMap<String, BufferedImage> cachedImages;
	
	public static final int FPS = 60;
	
	/**
	 * Inicializate the game panel
	 * @throws IOException 
	 * @throws HardestGameException 
	 */
	public TheDOPOHardestGameGUI(GameMode gameMode) throws IOException, HardestGameException {
		game = new TheDOPOHardestGame();
		game.startGame(gameMode, 1);
		//game = new TheDOPOHardestGame(1);
		cachedImages = new HashMap<>();
		prepareElements();
		prepareActions();
	}
	
	private void prepareActions() {
		
		keyH = new KeyHandler() {
			
		};
			
			
		this.addKeyListener(keyH);
	}

	private void prepareElements() throws IOException {
		setScreen();
		loadImages(); // <-- cargar una sola vez
    }

	/*
	 * Load the paths of images of objects of game
	 */
    private void loadImages() throws IOException {
    	HashMap<String, String> paths = game.getElementsToDraw();
        for (Entry<String, String> entry : paths.entrySet()) {
            String path = entry.getValue();
            InputStream stream = getClass().getResourceAsStream(path);
            if (stream == null) {
                System.err.println("loadImages| Recurso no encontrado en classpath " + path);
                continue;
            }
            try {
                BufferedImage img = ImageIO.read(stream);
                cachedImages.put(entry.getKey(), img);
            } catch (IOException e) {
                System.err.println("loadImages | Error al leer imagen " + path);
                e.printStackTrace();
            }
        }
    }
    
	private void setScreen() {
		this.setPreferredSize(new Dimension(DimensionGame.SCREENWIDTH, DimensionGame.SCREENHEIGHT));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}

	/**
	 * Make a thread to game run with time
	 */
	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if (delta >= 1) {
				// 1. UPDATE: 
				update();
				// 2. DRAW:
				repaint();
				delta--;
			}

			if (timer >= 1000000000) {
				timer -= 0;
			}
			try { // No ahogar la CPU 
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Make the interaction of keyboard with the player
	 */
	private void update() {
		if (keyH.getUp() == true) {
			game.movePlayers('u');
		}
		if (keyH.getDown() == true) {
			game.movePlayers('d');
		}
		if (keyH.getLeft() == true) {
			game.movePlayers('l');
		}
		if (keyH.getRigth() == true) {
			game.movePlayers('r');	
		}
	}

	/**
	 * Make game thread run
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	/**
	 * Draw at a panel g2 different entitys
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
        HashMap<Integer, Element> elements = game.getElements();

        loadMap(g2);
        
        // Dibujar; Tiles, obstáculos, monedas //Ayudado por claude sonnet 4.6 IA a poner el player encima
        for (Element e : elements.values()) {
            if (game.getPlayer1().equals(e)) continue;
            BufferedImage img = cachedImages.get(e.getNameClass());
            if (img != null) {
                g2.drawImage(img, e.getPosX(), e.getPosY(),
                    (int)(e.getSize() * DimensionGame.TILESIZEWIDTH),
                    (int)(e.getSize() * DimensionGame.TILESIZEWIDTH), null);
            }
        }        

        // Player encima
        BufferedImage img = cachedImages.get("player");
        if (img != null) {

            g2.drawImage(img, game.getPlayer1().getPosX(), game.getPlayer1().getPosY(),
                (int)(game.getPlayer1().getSize() * game.getPlayer1().getWidth()),
                (int)(game.getPlayer1().getSize() * game.getPlayer1().getHeight()), null);

        }
    }

	/*
	 * Load and draw tiles of map to the panel
	 */
	private void loadMap(Graphics2D g2) {
		int col = 0, row = 0, x = 0, y =0;
        int tileNum;
        int[][] mapTileNum = new int[DimensionGame.MAXWORLDROW][DimensionGame.MAXWORLDCOL];
        Tile currentTile;
        while (col < DimensionGame.MAXWORLDCOL && row <  DimensionGame.MAXWORLDROW) {
        	mapTileNum = game.loadMap();
        	tileNum = mapTileNum[row][col];
        	Tile[] tiles = game.loadTiles();
        	if (tileNum < 9 && tileNum >= 0) {
	        	currentTile = tiles[tileNum];
	        	BufferedImage img = cachedImages.get(currentTile.getNameClass());
	        	g2.drawImage(img, x, y,
	                    DimensionGame.TILESIZE,
	                    DimensionGame.TILESIZE, null);
	        	col++;
	        	x += DimensionGame.TILESIZE;
	        	
	        	if (col == DimensionGame.MAXWORLDCOL) {
	        		col = 0;
	        		row++;
	        		x = 0;
	        		y += DimensionGame.TILESIZE;
	        	}
        	}
        }
	}
	
	/**
	 * Paint components at the graphic
	 */
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    draw(g2);
	    g2.dispose();
	}
	
	
}

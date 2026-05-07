package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import domain.Element;

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
import domain.Player;
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
	 */
	public TheDOPOHardestGameGUI() throws IOException {
		game = new TheDOPOHardestGame(1);
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

    private void loadImages() throws IOException {
        HashMap<String, String> paths = game.getElementsToDraw();
        for (Entry<String, String> entry : paths.entrySet()) {
            try {
                BufferedImage img = ImageIO.read(
                    getClass().getResourceAsStream(entry.getValue()));
                cachedImages.put(entry.getKey(), img);
            } catch (IOException e) {
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
		}
	}

	private void update() {
		Player py = game.getPlayer();
		
		if (keyH.getUp() == true) {
			py.move('u');
		}
		if (keyH.getDown() == true) {
			py.move('d');
		}
		if (keyH.getLeft() == true) {
			py.move('l');
		}
		if (keyH.getRigth() == true) {
			py.move('r');	
		}
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void draw(Graphics2D g2) {
        HashMap<Integer, Element> elements = game.getElements();

        
        loadMap(g2);
        
        // Tiles, obstáculos, monedas //Ayudado por claude sonnet 4.6 IA a poner el player encima
        
        Player py = game.getPlayer();
        for (Element e : elements.values()) {
            if (e.equals(py)) continue;
            BufferedImage img = cachedImages.get(e.getNameClass());
            if (img != null) {
                g2.drawImage(img, e.getPosX(), e.getPosY(),
                    (int)(e.getSize() * DimensionGame.TILESIZEWIDTH),
                    (int)(e.getSize() * DimensionGame.TILESIZEWIDTH), null);
            }
        }
        
        

        // Player encima
        
        BufferedImage img = cachedImages.get(py.getNameClass());
        if (img != null) {
            g2.drawImage(img, py.getPosX(), py.getPosY(),
                (int)(py.getSize() * DimensionGame.TILESIZEWIDTH),
                (int)(py.getSize() * DimensionGame.TILESIZEWIDTH), null);
        }
    }

	
	private void loadMap(Graphics2D g2) {
		int col = 0, row = 0, x = 0, y =0;
        int tileNum;
        int[][] mapTileNum = new int[DimensionGame.MAXWORLDROW][DimensionGame.MAXWORLDCOL];
        while (col < DimensionGame.MAXWORLDCOL && row <  DimensionGame.MAXWORLDROW) {
        	mapTileNum = game.loadMap();
        	tileNum = mapTileNum[row][col];
        	Tile[] tiles = game.loadTiles();
        	Tile currentTile = tiles[tileNum];
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



	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    draw(g2);
	    g2.dispose();
	}
	
	
}

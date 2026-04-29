package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import domain.DimensionGame;
import domain.Player;
import domain.TheDOPOHardestGame;

public class TheDOPOHardestGameGUI extends JPanel implements Runnable {

	private static BufferedImage imageTitleScreen;

	private KeyHandler keyH;
	private Thread gameThread;
	private TheDOPOHardestGame game;
	private Player py;
	
	public static final int FPS = 60;
	
	/**
	 * Inicializate the game panel
	 */
	public TheDOPOHardestGameGUI() {
		game = new TheDOPOHardestGame();
		py = new Player();
		prepareElements();
		prepareActions();
		

	}

	private void prepareActions() {
		
		keyH = new KeyHandler() {
			@Override
			public void keyPressed(KeyEvent e) {
					
				int code = e.getKeyCode();
				
				if (code == KeyEvent.VK_W) {
					setUp(true);
				}
				if (code == KeyEvent.VK_S) {
					setDown(true);
				}
				if (code == KeyEvent.VK_D) {
					setRigth(true);
				}
				if (code == KeyEvent.VK_A) {
					setLeft(true);
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int code = e.getKeyCode();
				
				if (code == KeyEvent.VK_W) {
					setUp(false);
				}
				if (code == KeyEvent.VK_S) {
					setDown(false);
				}
				if (code == KeyEvent.VK_A) {
					setLeft(false);
				}
				if (code == KeyEvent.VK_D) {
					setRigth(false);
				}
			}
		};
			
			
		this.addKeyListener(keyH);
	}

	private void prepareElements() {
		setScreen();
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
		if (keyH.getUp() == true) {
			py.decrementSpeedPosY();
		}
		if (keyH.getDown() == true) {
			py.incrementSpeedPosY();
		}
		if (keyH.getLeft() == true) {
			py.decrementSpeedPosX();
		}
		if (keyH.getRigth() == true) {
			py.incrementSpeedPosX();		
		}
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void draw(Graphics2D g2) {
		
	}
}

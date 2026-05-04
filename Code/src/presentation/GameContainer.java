package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;

import domain.DimensionGame;

public class GameContainer extends JPanel{

	private BufferedImage backgroundImage;
	private CardLayout cardLayout;
	private JPanel cardPanel, tittlePanel;
	private TheDOPOHardestGameGUI playerModePanel;
	
	public static final String MENU_MODE = "menu";
	public static final String PLAYER_MODE = "player";
	public static final String PVP_MODE = "pvp";
	public static final String VS_MACHINE_MODE = "vsMachine";
	public static final String PLAYER_CONFIG_MODE = "playerConfig";
	
	public GameContainer() {
		prepareElements();
	}

	private void prepareElements(){
		loadImages();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(DimensionGame.SCREENWIDTH, DimensionGame.SCREENHEIGHT));
		
		tittlePanel = buildTittlePanel();
		add(tittlePanel, BorderLayout.NORTH);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setOpaque(false);
		
		cardPanel.add(new MenuPanel(this), MENU_MODE);
		cardPanel.add(new PlayerConfig(this), PLAYER_CONFIG_MODE);
		playerModePanel = new TheDOPOHardestGameGUI();
		cardPanel.add(playerModePanel, PLAYER_MODE);
		//cardPanel.add(new PlayerVsPlayerGUI(), "PVP MODE");
		//cardPanel.add(new PlayerVsMachineGUI(), "PY VSMACHINE MODE"));
		cardLayout.show(cardPanel, MENU_MODE);
		add(cardPanel, BorderLayout.CENTER);
	}
	
	private void loadImages() {
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background/backgroundMain.png"));
		} catch (IOException  e) {
			backgroundImage = null;
		}
	}
	
	private JPanel buildTittlePanel() {
		JPanel tittle = new JPanel();
		tittle.setOpaque(false);
		tittle.setPreferredSize(new Dimension(DimensionGame.SCREENWIDTH, DimensionGame.TITTLE_HEIGHT));
		return tittle;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		}
	}
	
	public void showMode(String mode) {
		boolean isMenu = MENU_MODE.equals(mode);
		tittlePanel.setVisible(isMenu);
		cardLayout.show(cardPanel, mode);
		revalidate();
		repaint();
		if (PLAYER_MODE.equals(mode)) {
			playerModePanel.requestFocusInWindow();
		}
	}

	public TheDOPOHardestGameGUI getPlayerModePanel() {
		return playerModePanel;
	}
}

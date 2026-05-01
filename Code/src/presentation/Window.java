package presentation;

import javax.swing.JFrame;

public class Window {

	private static JFrame window; 
	
	public static void main(String[] args) {
		
		window  = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Bad Ice Cream");
		
		TheDOPOHardestGameGUI gamePanel = new TheDOPOHardestGameGUI();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
		
		
	}

}

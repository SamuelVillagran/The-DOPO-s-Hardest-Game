package presentation;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame {

	private static JFrame window; 
	private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem optionOpen, optionSaveAs, optionImport, optionExportAs, optionNew, optionExit;
	
    public Window() {
    	setScreen();
    	prepareElements();
    	prepareActions();
	}
	
    private void prepareActions() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void prepareElements() {
		prepareElementsMenu();
		
	}
	
	private void prepareElementsMenu() {
		menuBar  = new JMenuBar();
    	menu = new JMenu("Archivo");
    	optionNew = new JMenuItem("Nuevo");
    	optionSaveAs = new JMenuItem("Guardar");
    	optionOpen = new JMenuItem("Abrir");
    	optionImport = new JMenuItem("Importar");
    	optionExportAs = new JMenuItem("Exportar como");
    	optionExit = new JMenuItem("Salir");
    	
    	menu.add(optionNew);
    	menu.addSeparator();
    	menu.add(optionSaveAs);
    	menu.add(optionOpen);
    	menu.addSeparator();
    	menu.add(optionExportAs);
    	menu.add(optionImport);
    	menu.addSeparator();
    	menu.add(optionExit);
    	
    	menuBar.add(menu);
    	setJMenuBar(menuBar);
	}
	

	private void setScreen() {
		setResizable(false);
		setTitle("The DOPO Hardest Game");
		
		//TheDOPOHardestGameGUI gamePanel = new TheDOPOHardestGameGUI();
		//window.add(gamePanel);
		GameContainer gameContainer = new GameContainer();
		add(gameContainer);
		
		pack();
		
		setLocationRelativeTo(null);
		
		
		gameContainer.getPlayerModePanel().startGameThread();
    }
    
    
	public static void main(String[] args) {
		window  = new Window();
		window.setVisible(true);
	}
}

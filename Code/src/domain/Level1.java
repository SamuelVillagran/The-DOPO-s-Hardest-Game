package domain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level1 extends Level {

	public Level1() {
		numCoin = 3;
		map = new Map(1);
		registerTiles();
		initialize();
	}
	
	public Level1(CollisionChecker cCheker) {
		numCoin = 3;
		map = new Map(1);
		registerTiles();
		this.cCheker = cCheker;
		initialize();
	}


	@Override
	public void initialize() {
		List<Point> movementEnemy1 = new LinkedList<>();
		addPointToListMovement(8, 9, movementEnemy1);
		addPointToListMovement(8, 25, movementEnemy1);
		putEnemy(movementEnemy1);
		List<Point> movementEnemy2 = new LinkedList<>();
		addPointToListMovement(9, 25, movementEnemy2);
		addPointToListMovement(9, 9, movementEnemy2);
		putEnemy(movementEnemy2);
		List<Point> movementEnemy3 = new LinkedList<>();
		addPointToListMovement(10, 9, movementEnemy3);
		addPointToListMovement(10, 25, movementEnemy3);
		putEnemy(movementEnemy3);
		List<Point> movementEnemy4 = new LinkedList<>();
		addPointToListMovement(11, 25, movementEnemy4);
		addPointToListMovement(11, 9, movementEnemy4);
		putEnemy(movementEnemy4);
	}
	
	private void addPointToListMovement(int row, int col, List<Point> movement) {
		int desface = DimensionGame.TILESIZE/2;
		movement.add(new Point(6*DimensionGame.TILESIZEWIDTH, 9*DimensionGame.TILESIZEHEIGHT-desface));
		
	}
	
	private void putEnemy(List<Point> movement) {
		elements.put(elements.size(), new Basic(movement, cCheker, this));
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Solid> getSolidElements() {
		List<Solid> solids = new ArrayList<>();
		for(Element element : elements.values()) {
			if(element instanceof Solid) {
				solids.add((Solid) element);
			}
		}
		return solids;
	}
	
	/**
	 * Put at the correct position the players of level1
	 * @param pys pys are the list of players that are at the level
	 */
	@Override
	public void spawnPlayers(List<Player> pys) {
		int desface = DimensionGame.TILESIZE/2, sizePys = pys.size();
		if (sizePys == 1) {
			pys.get(0).setAttributesPlayer(4*DimensionGame.TILESIZEWIDTH-desface, 8*DimensionGame.TILESIZEHEIGHT-desface);
		}
		if (sizePys > 1) {
			for (Player py : pys) {
				py.setAttributesPlayer(4*DimensionGame.TILESIZEWIDTH-desface, 8*DimensionGame.TILESIZEHEIGHT-desface);
			}
		}
		for(Player py : pys) {
			elements.put(elements.size() + 1, py);
		}
		
	}
}

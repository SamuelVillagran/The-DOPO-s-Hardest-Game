package domain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level1 extends Level {

	public Level1() {
		numCoin = 3;
		initialize();
		map = new Map(1);
	}

	@Override
	public void initialize() {
		int desface = DimensionGame.TILESIZE/2;
		List<Point> movementEnemy1 = new LinkedList<>();
		movementEnemy1.add(new Point(6*DimensionGame.TILESIZEWIDTH, 9*DimensionGame.TILESIZEHEIGHT-desface));
		movementEnemy1.add(new Point(25*DimensionGame.TILESIZEWIDTH-desface, 9*DimensionGame.TILESIZEHEIGHT-desface));
		elements.put(elements.size(), new Basic(movementEnemy1));
		List<Point> movementEnemy2 = new LinkedList<>();
		movementEnemy2.add(new Point(25*DimensionGame.TILESIZEWIDTH-desface, 10*DimensionGame.TILESIZEHEIGHT-desface));
		movementEnemy2.add(new Point(6*DimensionGame.TILESIZEWIDTH, 10*DimensionGame.TILESIZEHEIGHT-desface));
		elements.put(elements.size(), new Basic(movementEnemy2));
		List<Point> movementEnemy3 = new LinkedList<>();
		movementEnemy3.add(new Point(6*DimensionGame.TILESIZEWIDTH, 11*DimensionGame.TILESIZEHEIGHT-desface));
		movementEnemy3.add(new Point(25*DimensionGame.TILESIZEWIDTH-desface, 11*DimensionGame.TILESIZEHEIGHT));
		elements.put(elements.size(), new Basic(movementEnemy3));
		List<Point> movementEnemy4 = new LinkedList<>();
		movementEnemy4.add(new Point(25*DimensionGame.TILESIZEWIDTH-desface, 12*DimensionGame.TILESIZEHEIGHT-desface));
		movementEnemy4.add(new Point(6*DimensionGame.TILESIZEWIDTH-desface, 12*DimensionGame.TILESIZEHEIGHT));
		elements.put(elements.size(), new Basic(movementEnemy4));
		
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
		
	}
}

package domain;

import java.util.ArrayList;
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
		elements.put(elements.size(), new Enemy(6*DimensionGame.TILESIZEWIDTH, 9*DimensionGame.TILESIZEHEIGHT-desface));
		elements.put(elements.size(), new Enemy(25*DimensionGame.TILESIZEWIDTH-desface, 10*DimensionGame.TILESIZEHEIGHT-desface));
		elements.put(elements.size(), new Enemy(6*DimensionGame.TILESIZEWIDTH, 11*DimensionGame.TILESIZEHEIGHT-desface));
		elements.put(elements.size(), new Enemy(25*DimensionGame.TILESIZEWIDTH-desface, 12*DimensionGame.TILESIZEHEIGHT-desface));
		
	}

	@Override
	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Solid> getSolidEelements() {
		List<Solid> solids = new ArrayList<>();
		for(Element element : elements.values()) {
			if(element instanceof Solid) {
				solids.add((Solid) element);
			}
		}
		return solids;
	}
	
	public void spawnPlayers(List<Player> pys) {
		int desface = DimensionGame.TILESIZE/4, sizePys = pys.size();
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

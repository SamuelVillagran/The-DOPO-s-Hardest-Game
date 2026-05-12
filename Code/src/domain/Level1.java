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
		elements.put(elements.size(), new Coin());
		elements.put(elements.size(), new Enemy());
		elements.put(elements.size(), new Enemy(500, 500));
		elements.put(elements.size(), new Coin(300, 300));
		elements.put(elements.size(), new Coin(975, 150));
		elements.put(elements.size(), new Enemy(750, 75));
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
	
}

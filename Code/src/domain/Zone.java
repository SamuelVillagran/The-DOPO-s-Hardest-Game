package domain;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public abstract class Zone {

	private List<Tile> tiles;
	private Figure bounds;
	
	
	/**
	 * This is the zone Where going to affect the player
	 * @param form form is the coordinates of tiles to make the zone
	 */
	public Zone(List<Point> coordinatesTiles, String typeZone) {
		bounds = new Figure(coordinatesTiles);
		tiles = new LinkedList<>();
		switch (typeZone) {
			case "lifesourse":
				for (Point p : coordinatesTiles) {
					tiles.add(new LifeSource((int) p.getX(), (int) p.getY())); 
				}
				break;
			case "bomb":
				for (Point p : coordinatesTiles) {
					tiles.add(new Bomb((int) p.getX(), (int) p.getY()));
				}
				break;
		}
	}
}

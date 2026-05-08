package domain;

import java.awt.Point;
import java.util.List;

public abstract class Zone {

	private Tile[] tiles;
	private Figure bounds;
	
	//form : _List<Point>
	/**
	 * This is the zone Where going to affect the player
	 * @param form form is the coordinates of tiles to make the zone
	 */
	public Zone(List<Point> coordinatesTiles) {
		bounds = new Figure(coordinatesTiles);
		for (Point p : coordinatesTiles) {
			
		}
	}
	
	
}

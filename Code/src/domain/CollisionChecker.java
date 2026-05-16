package domain;

import java.util.List;

public class CollisionChecker {
	
	public boolean canMove(HitBox mover, int px, int py, CollisionContext context) {
		List<Solid> solidElements = context.getSolidElements();
		boolean isOverlaps = false;
		for (Solid solid : solidElements) {
            if (solid == mover) continue;
            isOverlaps = overlaps(px, py, mover, solid);
            if (isOverlaps) return false;
        }
        return true;
	}
	
	private boolean overlaps(int px, int py, HitBox mover, HitBox other) {
		 return px < ((Element) other).getPosX() + other.getWidth()
         && px + mover.getWidth() > ((Element)other).getPosX()
         && py < ((Element)other).getPosY() + other.getHeight()
         && py + mover.getHeight() > ((Element)other).getPosY();
	}

}

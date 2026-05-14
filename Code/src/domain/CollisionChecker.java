package domain;

public class CollisionChecker {
	
	public boolean canMove(HitBox mover, int px, int py, CollisionContext context) {
		for (Solid solid : context.getSolidElements()) {
            if (solid == mover) continue;
            if (overlaps(px, py, mover, solid)) return false;
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

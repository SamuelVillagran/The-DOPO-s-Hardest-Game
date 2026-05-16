package domain;

public class GreenTile extends Tile {

	public GreenTile(int xPos, int yPos) {
		posX = xPos;
		posY = yPos;
	}
	
	@Override
	public String getPathImage() {
		return "/"+getNameSuperClass()+"/"+getNameClass()+".png";
	}

	@Override
	public String getNameClass() {
		return getClass().getSimpleName().toLowerCase();
	}
}

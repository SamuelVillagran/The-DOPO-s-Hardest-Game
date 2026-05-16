package domain;

public class Wall extends Tile  implements Solid{

	public Wall() {
		posX = 150;
		posY = 150;
	}
	
	public String getNameClass() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getPathImage() {
		return "/"+getNameSuperClass()+"/"+getNameClass()+".png";
	}

	@Override
	public int getWidth() {
		return DimensionGame.TILESIZE;
	}

	@Override
	public int getHeight() {
		return DimensionGame.TILESIZE;
	}
}

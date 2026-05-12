package domain;

public class Floor extends Tile {

	
	public Floor() {
		posX = 200;
		posY = 200;
	}
	
	public String getNameClass() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getNameSuperClass() {
		return this.getClass().getSuperclass().getSimpleName().toLowerCase();
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

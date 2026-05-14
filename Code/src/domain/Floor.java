package domain;

public class Floor extends Tile {

	
	public Floor() {
		posX = 200;
		posY = 200;
	}
	
	@Override
	public int getWidth() {
		return 36;
	}

	@Override
	public int getHeight() {
		return 36;
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
}

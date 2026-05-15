package domain;

public class Floor extends Tile {

	
	public Floor(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
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

package domain;

public class Obstacle extends Tile {

	public Obstacle() {
		posX = 150;
		posY = 150;
	}
	
	public String getNameClass() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getPathImage() {
		return "/"+getNameSuperClass()+"/"+getNameClass()+".png";
	}
}

package domain;

public class Wall extends Tile  implements Solid{

	public Wall() {
		posX = 150;
		posY = 150;
	}
	
	public Wall(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public String getNameClass() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getPathImage() {
		return "/"+getNameSuperClass()+"/"+getNameClass()+".png";
	}
}

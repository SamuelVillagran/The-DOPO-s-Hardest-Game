package domain;

public class Coin extends Colectible {

	public Coin() {
		posX = 150;
		posY = 150;
		size = 0.5f;
	}
	
	public Coin(int x, int y) {
		posX = x;
		posY = y;
		size = 0.5f;
	}
	
	@Override
	public String getPathImage() {
		return "/"+ getClass().getSuperclass().getSimpleName().toLowerCase()+"/"+getNameClass()+".png";
	}

	@Override
	public String getNameClass() {
		return  this.getClass().getSimpleName().toLowerCase();
	}
	
}

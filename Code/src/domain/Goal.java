package domain;

public class Goal extends Tile {

	
	
	@Override
	public String getPathImage() {
		return super.getNameSuperClass()+"/"+getNameClass();
	}

	@Override
	public String getNameClass() {
		return "greenTile.png";
	}

	
	
}

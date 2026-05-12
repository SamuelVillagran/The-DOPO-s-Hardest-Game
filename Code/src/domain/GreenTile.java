package domain;

public class GreenTile extends Tile {

	
	
	

	@Override
	public int getWidth() {
		return 36;
	}

	@Override
	public int getHeight() {
		return 36;
	}

	@Override
	public String getPathImage() {
		return getNameSuperClass()+"/"+getNameClass()+".png";
	}

	@Override
	public String getNameClass() {
		return getClass().getSimpleName();
	}



	

	
	
}

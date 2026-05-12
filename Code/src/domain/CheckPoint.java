package domain;

public class CheckPoint extends Tile{

	@Override
	public String getPathImage() {
		return super.getNameSuperClass()+"/"+getNameClass();
	}

	@Override
	public String getNameClass() {
		return "greenTile.png";
	}

	@Override
	public int getWidth() {
		return 36;
	}

	@Override
	public int getHeight() {
		return 36;
	}
}

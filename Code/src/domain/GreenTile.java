package domain;

public class GreenTile extends Tile {

	@Override
	public String getPathImage() {
		return "/"+getNameSuperClass()+"/"+getNameClass()+".png";
	}

	@Override
	public String getNameClass() {
		return getClass().getSimpleName().toLowerCase();
	}
}

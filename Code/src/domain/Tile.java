package domain;

public abstract class Tile extends Element {

	
	
	public String getNameSuperClass() {
		return this.getClass().getSuperclass().getSimpleName().toLowerCase();
	}

}

package domain;

public abstract class StateEnemy implements StateEntity {

	protected Enemy enemy;
	
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	
}

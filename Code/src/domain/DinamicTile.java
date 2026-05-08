package domain;

public abstract class DinamicTile {

	private boolean isActive; 
	
	/**
	 * This make the interactions at the levels with the entities
	 * @param entity entity that going to interact with everything at the specific level
	 * @param level level is level that have diferents things to entities interacts
	 */
	public void interact(Entity entity, Level level) {
		
	}
	
	/**
	 * This method going to do some effect with the specific entity given
	 * @param entity entity that going to apply some special effect
	 */
	private void applyEffect(Entity entity) {
		
	}
	
}

package domain;

public class MachineContext {

	private int goalXPos;
	private int goalYPos;
	
	public MachineContext(Player self, int goalXPos, int goalYPos) {
		this.goalXPos = goalXPos;
		this.goalYPos = goalYPos;
	}
	
	
}

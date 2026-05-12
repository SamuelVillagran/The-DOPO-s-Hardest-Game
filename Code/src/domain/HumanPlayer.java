package domain;


public class HumanPlayer extends Player{

	public HumanPlayer(PlayerType type, String name) throws HardestGameException{
		super(type, name);
	}
	
	@Override
	public String getNameClass() {
		return "player";
	}
}

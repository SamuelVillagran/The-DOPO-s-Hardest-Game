package domain;

public class HardestGameException extends Exception{
	public static final String PLAYER_TYPE_UNKNOWN = "Tipo de jugador desconocido.";
	
	
	public HardestGameException(String message) {
		super(message);
	}
}

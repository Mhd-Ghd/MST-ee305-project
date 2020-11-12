import java.awt.Graphics;

public abstract class State {

	protected Game game;
	
	
	public  State(Game game) {
		this.game = game;
	}
	
	
	
	private static State currentState=null;
	
	
	
	public static State getCurrentState() {
		return currentState;
	}
	public static void setCurrentState(State state) {
		currentState = state;
	}
	
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}

package COMuscle;

public class PanneauSTOP extends Semaphore {
	
	public PanneauSTOP () {
		super();
	}
	
	public PanneauSTOP (Extremite extremite) {
		super(extremite);
	}
	
}

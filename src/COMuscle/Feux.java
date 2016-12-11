package COMuscle;

public class Feux extends Semaphore {

	public Feux() {
		super();
	}

	public Feux(Extremite extremite) {
		super(extremite);
	}
}

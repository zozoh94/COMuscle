package COMuscle;

public class Feu extends Semaphore {
	protected EnumFeu etat;

	public Feu() {
		super();

	}

	public Feu(Extremite extremite) {
		super(extremite);
	}
}

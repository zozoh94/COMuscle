package COMuscle;

public class Feu extends Semaphore {
	protected EnumFeu etat;

	public Feu() {
		super();

	}
	
	public EnumFeu getEtat() {
		return etat;
	}
	
	public void setEtat(EnumFeu e) {
		etat=e;
	}

	public Feu(Extremite extremite) {
		super(extremite);
	}
}

package COMuscle;

public class FeuTricolore extends Semaphore {
	TricolorEnum etat;
	
	public FeuTricolore(Extremite extremite) {
		super(extremite);
		etat = TricolorEnum.ROUGE;
	}
	
	public FeuTricolore(TricolorEnum etat_) {
		etat = etat_;
	}
	
	public String toString() {
		return etat.toString();
	}
}

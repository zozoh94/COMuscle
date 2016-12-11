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
	
	public void update() {
		if (this.etat==TricolorEnum.ROUGE) this.etat=TricolorEnum.VERT;
		else if (this.etat==TricolorEnum.ORANGE) this.etat=TricolorEnum.ROUGE;
		else this.etat=TricolorEnum.ORANGE;
	}
}

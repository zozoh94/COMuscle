package COMuscle;

public class FeuBicolore extends Feux {
	BicolorEnum etat;
	
	public FeuBicolore(BicolorEnum etat_) {
		etat=etat_;
	}
	
	public String toString() {
		return etat.toString();
	}
}

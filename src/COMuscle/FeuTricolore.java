package COMuscle;

public class FeuTricolore extends Feux{
	TricolorEnum etat;
	
	public FeuTricolore(TricolorEnum etat_) {
		etat=etat_;
	}
	
	public String toString() {
		return etat.toString();
	}
}

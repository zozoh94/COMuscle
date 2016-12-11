package COMuscle;

public class FeuBicolore extends Feux {
	BicolorEnum etat;
	
	public FeuBicolore(BicolorEnum etat_) {
		etat=etat_;
	}
	
	
	public void update() {
		if (this.etat==BicolorEnum.ROUGE) this.etat=BicolorEnum.VERT;
		else this.etat=BicolorEnum.ROUGE;
	}
	
	
	public String toString() {
		return etat.toString();
	}
}

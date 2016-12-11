package COMuscle;

public class FeuBicolore extends Feu {
	private EnumFeu etat;

	public FeuBicolore(EnumFeu etat_) {
		if (etat_ == EnumFeu.ORANGE)
			System.out.println("Erreur c'est un feu Bicolore !!");
		else
			etat = etat_;

	}
	public FeuBicolore(Extremite extremite) {
		super(extremite);
		etat = EnumFeu.ROUGE;
}

	public void update() {

		if (this.etat == EnumFeu.ROUGE)
			this.etat = EnumFeu.VERT;
		else
			this.etat = EnumFeu.ROUGE;

	}
	public void periodiqueColorChange(){
	if (Main.temps%2==0)
		this.update();
	
	}

	public String toString() {
		return etat.toString();
	}
}

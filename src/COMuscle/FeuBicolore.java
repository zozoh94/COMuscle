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

	public String toString() {
		return etat.toString();
	}
}

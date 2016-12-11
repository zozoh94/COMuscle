package COMuscle;

public class FeuTricolore extends Feu {
	private EnumFeu etat;

	public FeuTricolore(EnumFeu etat_) {
		etat = etat_;
	}

	public FeuTricolore(Extremite extremite) {
		super(extremite);
		etat = EnumFeu.VERT;
	}

	public void setEtat(EnumFeu e) {
		etat = e;
	}

	public String toString() {
		return etat.toString();
	}

	public void update() {
		if (this.etat == EnumFeu.ROUGE)
			this.etat = EnumFeu.VERT;
		else if (this.etat == EnumFeu.ORANGE)
			this.etat = EnumFeu.ROUGE;
		else
			this.etat = EnumFeu.ORANGE;
	}

	public void periodiqueColorChange() {
		if (Main.temps % 2 == 0)
			this.update();

	}
}

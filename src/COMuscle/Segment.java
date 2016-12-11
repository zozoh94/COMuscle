package COMuscle;

public class Segment extends Emplacement {

	public Segment() {
		super();
	}

	public Segment(int longueur) {
		this();
		this.longueur = longueur;
	}

	public Segment(int longueur, boolean creerExtremites) {
		this(creerExtremites);
		this.longueur = longueur;
	}

	public Segment(boolean creerExtremites) {
		this();
		if (creerExtremites) {
			extremites.add(new Extremite(this));
			extremites.add(new Extremite(this));
		}
	}

	public Segment(Extremite extremite1, Extremite extremite2) {
		super();
		extremites.add(extremite1);
		extremites.add(extremite2);
	}
	
	public Emplacement recupererEmplacementSuivant(int sens) {
		return this.extremites.get(sens).getSaJonction();
	}
	
	public String toString() {
		return "Seg#" + this.getId();
	}
	

	/* GETTERS ET SETTERS */
	public Extremite getExtremite1() {
		return extremites.get(0);
	}

	public void setExtremite1(Extremite extremite1) {
		this.extremites.set(0, extremite1);
		this.extremites.get(0).setSonSegment(this);
	}

	public Extremite getExtremite2() {
		return this.extremites.get(1);
	}

	public void setExtremite2(Extremite extremite2) {
		this.extremites.set(1, extremite2);
		this.extremites.get(1).setSonSegment(this);
	}
}

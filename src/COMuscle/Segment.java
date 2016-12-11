package COMuscle;

public class Segment extends Emplacement {
	private Extremite extremite1;
	private Extremite extremite2;

	public Segment() {
		super();
	}

	public Segment(Extremite extremite1, Extremite extremite2) {
		super();
		this.extremite1 = extremite1;
		this.extremite2 = extremite2;
	}

	public Segment(boolean creerExtremites) {
		super();
		if (creerExtremites) {
			extremite1 = new Extremite(this);
			extremite2 = new Extremite(this);
		}
	}

	public Extremite getExtremite1() {
		return extremite1;
	}

	public void setExtremite1(Extremite extremite1) {
		this.extremite1 = extremite1;
		this.extremite1.setSonSegment(this);
	}

	public Extremite getExtremite2() {
		return extremite2;
	}

	public void setExtremite2(Extremite extremite2) {
		this.extremite2 = extremite2;
		this.extremite2.setSonSegment(this);
	}
}

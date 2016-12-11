package COMuscle;

public enum VehiculeEtat {
	AVANCE("Avance"),
	ARRETTEMPORAIRE("Arr�t temporaire"),
	ARRETTERMINE("Arr�t termin�"),
	ARRET("Arr�t (temps ind�fini)");
	
	private String name = "";
	
	VehiculeEtat(String etat) {
		name = etat;
	}
	
	public String toString() {
		return name;
	}
}

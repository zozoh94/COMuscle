package COMuscle;

public enum VehiculeEtat {
	AVANCE("Avance"),
	ARRETTEMPORAIRE("Arrêt temporaire"),
	ARRETTERMINE("Arrêt terminé"),
	ARRET("Arrêt (temps indéfini)");
	
	private String name = "";
	
	VehiculeEtat(String etat) {
		name = etat;
	}
	
	public String toString() {
		return name;
	}
}

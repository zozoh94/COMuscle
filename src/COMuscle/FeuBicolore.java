package COMuscle;

public class FeuBicolore extends Feux {
	BicolorEnum etat;
	
	public FeuBicolore(Extremite extremite) {
		super(extremite);
	}
	
	public FeuBicolore(Extremite extremite, BicolorEnum etat) {
		super(extremite);
		this.etat = etat;
	}
	
	
	public void update() {
		if (this.etat == BicolorEnum.ROUGE) this.etat = BicolorEnum.VERT;
		else this.etat = BicolorEnum.ROUGE;
	}
	
	public void gererEtatVehicule(Vehicule vehicule) {
		
		// DEBUG ONLY, je change la couleur du feu juste pour montrer qu'après le temps 16 la voiture avance (ça créera un bug du coup)
		if (Main.temps > 16)
			this.etat = BicolorEnum.VERT;
		
		// Si le véhicule est en train d'avancer, on l'arrête tant que le feu est rouge
		if (this.etat == BicolorEnum.ROUGE && vehicule.getEtat() == VehiculeEtat.AVANCE) {
			vehicule.setEtat(VehiculeEtat.ARRET); // 3 = arrêt tps indéterminé
		}
		
		// Sinon si feu vert et que le véhicule est à l'arrêt, on le remet à l'état d'avancement (0)
		else if (this.etat == BicolorEnum.VERT && (vehicule.getEtat() == VehiculeEtat.ARRET || vehicule.getEtat() == VehiculeEtat.ARRETTEMPORAIRE))
			vehicule.setEtat(VehiculeEtat.AVANCE);
			
		
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = à l'arrêt temporairement (stop), 2 = a fini un arrêt, 3 = à l'arrêt pour un temps indéterminé
	}


	public BicolorEnum getEtat() {
		return etat;
	}

	public void setEtat(BicolorEnum etat) {
		this.etat = etat;
	}
	
}

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
		
		// DEBUG ONLY, je change la couleur du feu juste pour montrer qu'apr�s le temps 16 la voiture avance (�a cr�era un bug du coup)
		if (Main.temps > 16)
			this.etat = BicolorEnum.VERT;
		
		// Si le v�hicule est en train d'avancer, on l'arr�te tant que le feu est rouge
		if (this.etat == BicolorEnum.ROUGE && vehicule.getEtat() == VehiculeEtat.AVANCE) {
			vehicule.setEtat(VehiculeEtat.ARRET); // 3 = arr�t tps ind�termin�
		}
		
		// Sinon si feu vert et que le v�hicule est � l'arr�t, on le remet � l'�tat d'avancement (0)
		else if (this.etat == BicolorEnum.VERT && (vehicule.getEtat() == VehiculeEtat.ARRET || vehicule.getEtat() == VehiculeEtat.ARRETTEMPORAIRE))
			vehicule.setEtat(VehiculeEtat.AVANCE);
			
		
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = � l'arr�t temporairement (stop), 2 = a fini un arr�t, 3 = � l'arr�t pour un temps ind�termin�
	}


	public BicolorEnum getEtat() {
		return etat;
	}

	public void setEtat(BicolorEnum etat) {
		this.etat = etat;
	}
	
}

package COMuscle;


public class FeuBicolore extends Feu {
	private EnumFeu etat;

	public FeuBicolore(EnumFeu etat) {
		if (etat == EnumFeu.ORANGE)
			System.out.println("Erreur c'est un feu Bicolore !!");
		else
			etat = etat;
  }

	public FeuBicolore(Extremite extremite, EnumFeu etat) {
		super(extremite);
		this.etat = etat;
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
	
	public void gererEtatVehicule(Vehicule vehicule) {
		
		// DEBUG ONLY, je change la couleur du feu juste pour montrer qu'après le temps 16 la voiture avance (ça créera un bug du coup)
		if (Main.temps > 16)
			this.etat = EnumFeu.VERT;
		
		// Si le véhicule est en train d'avancer, on l'arrête tant que le feu est rouge
		if (this.etat == EnumFeu.ROUGE && vehicule.getEtat() == VehiculeEtat.AVANCE) {
			vehicule.setEtat(VehiculeEtat.ARRET); // 3 = arrêt tps indéterminé
		}
		
		// Sinon si feu vert et que le véhicule est à l'arrêt, on le remet à l'état d'avancement (0)
		else if (this.etat == EnumFeu.VERT && (vehicule.getEtat() == VehiculeEtat.ARRET || vehicule.getEtat() == VehiculeEtat.ARRETTEMPORAIRE))
			vehicule.setEtat(VehiculeEtat.AVANCE);
			
		
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = à l'arrêt temporairement (stop), 2 = a fini un arrêt, 3 = à l'arrêt pour un temps indéterminé
	}


	public EnumFeu getEtat() {
		return etat;
	}

	public void setEtat(EnumFeu etat) {
		this.etat = etat;
	}
	
}

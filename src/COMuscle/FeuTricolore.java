package COMuscle;

public class FeuTricolore extends Feu {
	private EnumFeu etat;
	
	public FeuTricolore(EnumFeu etat) {
		etat = etat;
	}
	
	public FeuTricolore(Extremite extremite) {
		super(extremite);
		etat = EnumFeu.ORANGE;
	}
	
	public FeuTricolore(Extremite extremite, EnumFeu etat) {
		super(extremite);
		this.etat = etat;
	}
	
	public void setEtat(EnumFeu e) {
		etat = e;
	}
	
	public String toString() {
		return etat.toString();
	}
	
	public void update() {
		if (this.etat == EnumFeu.ROUGE) this.etat = EnumFeu.VERT;
		else if (this.etat == EnumFeu.ORANGE) this.etat = EnumFeu.ROUGE;
		else this.etat = EnumFeu.ORANGE;
	}
	
	public void gererEtatVehicule(Vehicule vehicule) {
		
		// DEBUG ONLY, je change la couleur du feu juste pour montrer qu'après le temps 16 la voiture avance (ça créera un bug du coup)
		if (Main.temps > 25)
			this.etat = EnumFeu.VERT;
		else if (Main.temps > 18)
			this.etat = EnumFeu.ROUGE;
		

    	int newPos = vehicule.getPosition().getPosition() + vehicule.getVitesse();
		
    	// Si le vꩩcule va arriver au niveau du feu
    	if (newPos >= vehicule.getPosition().getEmplacement().getLongueur())
    	{
			// Si le véhicule est en train d'avancer, on l'arrête tant que le feu est rouge
			if (this.etat == EnumFeu.ROUGE && vehicule.getEtat() == VehiculeEtat.AVANCE) {
				vehicule.setEtat(VehiculeEtat.ARRET); // 3 = arrêt tps indéterminé
			}
			
			// Sinon si feu vert et que le véhicule est à l'arrêt, on le remet à l'état d'avancement (0)
			else if (this.etat == EnumFeu.VERT && (vehicule.getEtat() == VehiculeEtat.ARRET || vehicule.getEtat() == VehiculeEtat.ARRETTEMPORAIRE))
				vehicule.setEtat(VehiculeEtat.AVANCE);
    	}
    	// Sinon si le vꩩcule est loin et avance on divise sa vitesse par deux
    	else if (this.etat == EnumFeu.ORANGE && vehicule.getEtat() == VehiculeEtat.AVANCE)
    		vehicule.setVitesse(vehicule.getVitesseMax()/2);
		
	}
}

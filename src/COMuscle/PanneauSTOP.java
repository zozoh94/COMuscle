package COMuscle;

public class PanneauSTOP extends Semaphore {
	
	public PanneauSTOP () {
		super();
	}
	
	public PanneauSTOP (Extremite extremite) {
		super(extremite);
	}

	public void gererEtatVehicule(Vehicule vehicule) {

    	int newPos = vehicule.getPosition().getPosition() + vehicule.getVitesse();
    	
		if (newPos >= vehicule.getPosition().getEmplacement().getLongueur() // Si le véhicule va arriver au niveau du panneau STOP
			&& vehicule.getEtat() == VehiculeEtat.AVANCE) // Et qu'il est en train d'avancer
			vehicule.setEtat(VehiculeEtat.ARRETTEMPORAIRE); // On l'arrête temporairement (1 tour)
	}
	
}

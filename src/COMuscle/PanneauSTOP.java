package COMuscle;

public class PanneauSTOP extends Semaphore {
	
	public PanneauSTOP () {
		super();
	}
	
	public PanneauSTOP (Extremite extremite) {
		super(extremite);
	}

	public void gererEtatVehicule(Vehicule vehicule) {
		// Si le véhicule est en train d'avancer, on l'arrête temporairement (1 tour)
		if (vehicule.getEtat() == VehiculeEtat.AVANCE)
			vehicule.setEtat(VehiculeEtat.ARRETTEMPORAIRE);
		
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = à l'arrêt temporairement (stop), 2 = a fini un arrêt, 3 = à l'arrêt pour un temps indéterminé
	}
	
}

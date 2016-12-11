package COMuscle;

public class PanneauSTOP extends Semaphore {
	
	public PanneauSTOP () {
		super();
	}
	
	public PanneauSTOP (Extremite extremite) {
		super(extremite);
	}

	public void gererEtatVehicule(Vehicule vehicule) {
		// Si le v�hicule est en train d'avancer, on l'arr�te temporairement (1 tour)
		if (vehicule.getEtat() == VehiculeEtat.AVANCE)
			vehicule.setEtat(VehiculeEtat.ARRETTEMPORAIRE);
		
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = � l'arr�t temporairement (stop), 2 = a fini un arr�t, 3 = � l'arr�t pour un temps ind�termin�
	}
	
}

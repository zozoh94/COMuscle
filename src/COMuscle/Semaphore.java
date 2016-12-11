package COMuscle;

public abstract class Semaphore {
	protected Extremite sonExtremite;
	
	public Semaphore() {
	}
	
	public Semaphore(Extremite extremite) {
		sonExtremite = extremite;
		extremite.addSesSemaphores(this);
	}
	
	public void gererEtatVehicule(Vehicule vehicule) {
		// Le but ici sera de modifier l'�tat du v�hicule en fonction du semaphore, voir exemple avec PanneauSTOP et FeuBicolore
		// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = � l'arr�t temporairement (stop), 2 = a fini un arr�t, 3 = � l'arr�t pour un temps ind�termin�
	}
	
	public Extremite getSonExtremite() {
		return sonExtremite;
	}
	
	public void setSonExtremite(Extremite e) {
		sonExtremite = e;
	}
	
	public String type() {
		return getClass().getName();
	}
}
package COMuscle;

import java.util.ArrayList;

public class Regulateur {
    private ArrayList<Semaphore> semaphores;
    private ArrayList<Capteur> capteurs;

    public ArrayList<Semaphore> getSemaphores() {
        return semaphores;
    }

    public void setSemaphores(ArrayList<Semaphore> semaphores) {
        this.semaphores = semaphores;
    }

    public ArrayList<Capteur> getCapteurs() {
        return capteurs;
    }

    public void setCapteurs(ArrayList<Capteur> capteurs) {
        this.capteurs = capteurs;
    }

    public  void addSemaphore(Semaphore semaphore) {
        this.semaphores.add(semaphore);
    }

    public void removeSemaphore(Semaphore semaphore) {
        this.semaphores.remove(semaphore);
    }

    public  void addcapteur(Capteur capteur) {
        this.capteurs.add(capteur);
    }

    public void removecapteur(Capteur capteur) {
        this.capteurs.remove(capteur);
    }
}

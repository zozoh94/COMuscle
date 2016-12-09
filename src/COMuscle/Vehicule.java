package COMuscle;

public class Vehicule {
    protected Emplacement emplacement;
    protected ArrayList<Vehicule> sesVehicules;
    
    /* GETTERS ET SETTERS */
    
    public ArrayList<Vehicule> getSesVehicules() {
        return sesVehicules;
    }
    
    public void setSesVehicules(ArrayList<Vehicule> sesVehicules_) {
        this.sesVehicules = sesVehicules_;
    }
    
    public void addVehicule(Vehicule vehicule) {
        this.sesVehicules.add(vehicule);
    }

    public void removeVehicule(Vehicule vehicule) {
        this.sesVehicules.remove(vehicule);
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }
}

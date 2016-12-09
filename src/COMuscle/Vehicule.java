package COMuscle;

public abstract class Vehicule {
    protected Emplacement emplacement;
    protected int place; // coordonnées précises sur l'emplacement
    protected int vitesse;
    
    public void deplacement() {
        this.place += this.vitesse; // à modif pour gérer les cas où la caisse change d'emplacement
    }
    
    /* GETTERS ET SETTERS */
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse_) {
        this.vitesse = vitesse_;
    }
    
    public int getPlace() {
        return place;
    }
    
    public void setPlace(int place_) {
        this.place = place_;
    }
    
    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }
}

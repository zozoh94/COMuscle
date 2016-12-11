package COMuscle;

public abstract class Vehicule {
	
	public static int compteur = 0;
	
    protected Position position;
    protected int id;
    protected int longueur;
    protected int vitesse;
    
    public Vehicule () {
		this.id = Vehicule.compteur++;
		this.vitesse = 1;
    }
    
    public Vehicule (Position position) {
		this();
		this.position = position;
		this.position.getEmplacement().addVehicule(this);
    }
    
    public void deplacer() {
    	
    	int newPos = this.position.getPosition() + this.vitesse;
    	
    	// On sort de l'emplacement actuel ?
    	if (newPos >= this.position.getEmplacement().getLongueur()) {
    		// On récupère l'emplacement suivant (qui peut être un segment ou une jonction) en fonction du sens dans lequel le véhicule avance (i.e. en fonction de la file)
    		this.position.setEmplacement(this.position.getEmplacement().recupererEmplacementSuivant(this.position.getFile().getSens()));
    		this.position.setPosition(0); // On oublit pas de réinitialiser la position sur le nouvel emplacement
    	}
    	// Sinon on continue d'avancer sur l'emplacement
    	else
    		this.position.setPosition(newPos);
    }
    
    /* GETTERS ET SETTERS */
    
    public int getId() {
    	return id;
    }
    
    public int getLongueur() {
    	return longueur;
    }
    
    public void setLongueur(int longueur) {
    	this.longueur = longueur;
    }
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    
    public String toString() {
    	return "[Vehicule,#" + this.id + ",Vt:" + this.vitesse + ",Lg;" + this.longueur + "," + this.position + "]";
    }
}

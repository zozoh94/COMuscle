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
    }
    
    public void deplacement() {
        this.position.setPosition(this.position.getPosition() + this.vitesse); // à modif pour gérer les cas où la caisse change d'emplacement
    }
    
    /* GETTERS ET SETTERS */
    
    public int getId() {
    	return id;
    }
    
    public int getLongueur() {
    	return longueur;
    }
    
    public void setLongueur(int longueur_) {
    	this.longueur = longueur_;
    }
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse_) {
        this.vitesse = vitesse_;
    }
}

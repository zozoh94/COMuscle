package COMuscle;

public abstract class Vehicule {
	
	public static int compteur = 0;
	
    protected Position position;
    protected int id;
    protected int longueur;
    protected int vitesse;
    protected int vitesseMax;
    
    private VehiculeEtat etat; // 0 = en train d'avancer, 1 = ï¿½ l'arrï¿½t temporairement (stop), 2 = a fini un arrï¿½t, 3 = ï¿½ l'arrï¿½t pour un temps indï¿½terminï¿½
    
    public Vehicule () {
		this.id = Vehicule.compteur++;
		this.vitesseMax = 10;
		this.vitesse = 10;
		this.etat = VehiculeEtat.AVANCE;
    }
    
    public Vehicule (Position position) {
		this();
		this.position = position;
		this.position.getEmplacement().addVehicule(this);
    }
    
    public void deplacer() throws DemiTourImpossibleException{

    	if (this.peutAvancer()) {
    		
    		int newPos = this.position.getPosition() + this.vitesse;
	    	
	    	// On sort de l'emplacement actuel ?
	    	if (newPos >= this.position.getEmplacement().getLongueur()) {
		    			
	    		// On rï¿½cupï¿½re l'emplacement suivant (qui peut ï¿½tre un segment ou une jonction) en fonction du sens dans lequel le vï¿½hicule avance (i.e. en fonction de la file)
	    		if(this.position.getEmplacement() instanceof ContinuableEmplacement) {
                    this.position.getEmplacement().removeVehicule(this);
                    Emplacement emplacementSuivant = ((ContinuableEmplacement)(this.position.getEmplacement())).recupererEmplacementSuivant(this.position.getFile().getSens());
                    if(emplacementSuivant != null)
                        this.position.setEmplacement(emplacementSuivant);
                    else {
                        //On fait demi-tour la voie est sans issue si une file retour est disponible
                        int sensActuel = this.position.getFile().getSens();
                        File fileTrouve = null;
                        for (File file: this.position.getEmplacement().getFiles()) {
                             if(file.getSens() != sensActuel) {
                                 fileTrouve = file;
                                 break;
                             }
                        }
                        if(fileTrouve != null)
                            this.position.setFile(fileTrouve);
                        else
                            throw new DemiTourImpossibleException();
                    }
                    this.position.setPosition(0); // On oublit pas de rï¿½initialiser la position sur le nouvel emplacement
                    this.position.getEmplacement().addVehicule(this);
                }
		    		
	    	}
	    	// Sinon on continue d'avancer sur l'emplacement
	    	else
	    		this.position.setPosition(newPos);
    	}
    }
    
    public boolean peutAvancer() {
    	
    	// On utilise l'ï¿½tat du vï¿½hicule pour savoir s'il peut avancer
    	// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = ï¿½ l'arrï¿½t temporairement (stop), 2 = a fini un arrï¿½t, 3 = ï¿½ l'arrï¿½t pour un temps indï¿½terminï¿½
    	
    	if (etat == VehiculeEtat.ARRETTEMPORAIRE) // On est dï¿½jï¿½ ï¿½ l'arrï¿½t avant d'analyser les semaphores ?  C'est qu'on s'est dï¿½jï¿½ arrï¿½tï¿½, on le prï¿½cise
			etat = VehiculeEtat.ARRETTERMINE;
		
		this.gererComportementSelonSemaphores(); // Analyse des semaphores
		
		if (etat == VehiculeEtat.ARRETTEMPORAIRE || etat == VehiculeEtat.ARRET) // On est ï¿½ l'arrï¿½t suite ï¿½ l'analyse des semaphores ? Premiï¿½re fois qu'on s'arrï¿½te, on se dï¿½place pas
			return false;
		
		if (etat == VehiculeEtat.ARRETTERMINE)
    		etat = VehiculeEtat.AVANCE;
		
		return true;
    }
    
    public void gererComportementSelonSemaphores() {
    	
    	Extremite extremite = this.position.getEmplacement().getExtremites().get(this.position.getFile().getSens());
	    	
    	// On parcourt tous les semaphores
		for (int i = 0 ; i < extremite.getSesSemaphores().size() ; i ++)
			extremite.getSesSemaphores().get(i).gererEtatVehicule(this);
			
		
		// ---- Ancienne version, pas assez de modularitï¿½, il faut passer par une mï¿½thode gï¿½nï¿½raliste "gererEtatVehicule"
		// ---- sur les semaphores pour pouvoir ajouter facilement de nouveaux semaphores (c'est ce genre de chose qu'attend le prof)
		// Panneau STOP (le plus simple)
		/*if (etat == 0 && extremite.getSesSemaphores().get(i).type().contains("PanneauSTOP"))
			etat = 1;*/
		
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
    
    public int getVitesseMax() {
        return vitesseMax;
    }
    
    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
        this.vitesse = vitesseMax; // on adapte la vitesse
    }
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
        
        // Au cas o񠬡 voiture va trop vite, on 귩te l'incoh곥nce
        if (this.vitesse > vitesseMax)
        	this.vitesseMax = this.vitesse;
    }
    
    public VehiculeEtat getEtat() {
    	return this.etat;
    }
    
    public void setEtat(VehiculeEtat etat) {
    	this.etat = etat;
    }
    
    public String toString() {
    	return "[Vehicule,#" + this.id + ",Vt:" + this.vitesse + ",Lg;" + this.longueur + "," + this.position + "]";
    }

	public Position getPosition() {
		return position;
	}
}

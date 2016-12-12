package COMuscle;

public abstract class Vehicule {
	
	public static int compteur = 0;
	
    protected Position position;
    protected int id;
    protected int longueur;
    protected int vitesse;
    
    private VehiculeEtat etat; // 0 = en train d'avancer, 1 = � l'arr�t temporairement (stop), 2 = a fini un arr�t, 3 = � l'arr�t pour un temps ind�termin�
    
    public Vehicule () {
		this.id = Vehicule.compteur++;
		this.vitesse = 1;
		this.etat = VehiculeEtat.AVANCE;
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
    		
    		// On est � une extr�mit�, on v�rifie qu'il y ai pas un semaphore qui nous bloque (type feux, panneaux stop)
    		if (this.peutAvancer()) {
    			
	    		// On r�cup�re l'emplacement suivant (qui peut �tre un segment ou une jonction) en fonction du sens dans lequel le v�hicule avance (i.e. en fonction de la file)
	    		if(this.position.getEmplacement() instanceof ContinuableEmplacement) {
                    this.position.getEmplacement().removeVehicule(this);
                    this.position.setEmplacement(this.position.getEmplacement().recupererEmplacementSuivant(this.position.getFile().getSens()));
                    this.position.setPosition(0); // On oublit pas de r�initialiser la position sur le nouvel emplacement
                    this.position.getEmplacement().addVehicule(this);
                }
    		}
    	}
    	// Sinon on continue d'avancer sur l'emplacement
    	else
    		this.position.setPosition(newPos);
    }
    
    public boolean peutAvancer() {
    	
    	// On utilise l'�tat du v�hicule pour savoir s'il peut avancer
    	// Rappel des valeurs de "etat" : 0 = en train d'avancer, 1 = � l'arr�t temporairement (stop), 2 = a fini un arr�t, 3 = � l'arr�t pour un temps ind�termin�
    	
    	if (etat == VehiculeEtat.ARRETTEMPORAIRE) // On est d�j� � l'arr�t avant d'analyser les semaphores ?  C'est qu'on s'est d�j� arr�t�, on le pr�cise
			etat = VehiculeEtat.ARRETTERMINE;
		
		this.gererComportementSelonSemaphores(); // Analyse des semaphores
		
		if (etat == VehiculeEtat.ARRETTEMPORAIRE || etat == VehiculeEtat.ARRET) // On est � l'arr�t suite � l'analyse des semaphores ? Premi�re fois qu'on s'arr�te, on se d�place pas
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
			
		
		// ---- Ancienne version, pas assez de modularit�, il faut passer par une m�thode g�n�raliste "gererEtatVehicule"
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
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
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

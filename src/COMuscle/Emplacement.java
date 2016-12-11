package COMuscle;

import java.util.ArrayList;

public abstract class Emplacement {

	public static int compteur = 0;
	
	private int id;
	protected int longueur;
    protected ArrayList<Extremite> extremites;
	private ArrayList<File> files;
	private ArrayList<Vehicule> sesVehicules;
	
	public Emplacement() {
		this.id = Emplacement.compteur++;
		
		this.sesVehicules = new ArrayList<Vehicule>();
		this.files = new ArrayList<File>();
        this.extremites = new ArrayList<Extremite>();
	}
	
	public Emplacement(ArrayList<Extremite> extremites) {
		this();
        this.extremites = extremites;
	}
	
	public Emplacement recupererEmplacementSuivant(int sens) {
		return null;
	}
    
	public String toString() {
		return "Emp#" + this.id;
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
	
	public ArrayList<File> getFiles() {
		return files;
	}
	
	public void addFile(File file) {
		this.files.add(file);
	}
	
	public void addFiles(ArrayList<File> files) {
		this.files.addAll(files);
	}
	
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
	
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
    
    public ArrayList<Extremite> getExtremites() {
        return extremites;
    }

    public void setExtremites(ArrayList<Extremite> extremites) {
        this.extremites = extremites;
    }

    public  void addExtremite(Extremite extremite) {
        this.extremites.add(extremite);
    }

    public void removeExtremite(Extremite extremite) {
        this.extremites.remove(extremite);
    }
}

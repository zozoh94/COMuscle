package COMuscle;

import java.util.ArrayList;

public abstract class Emplacement {
	protected int longueur;
	protected ArrayList<File> files;
	protected ArrayList<Vehicule> sesVehicules;
	
	public Emplacement() {
		files = new ArrayList<File>();
	}
  
	/* GETTERS ET SETTERS */
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
}

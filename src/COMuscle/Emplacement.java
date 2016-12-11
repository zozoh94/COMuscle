package COMuscle;

import java.util.ArrayList;

public abstract class Emplacement {
	protected int longueur;
	ArrayList<File> files;
	
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
}

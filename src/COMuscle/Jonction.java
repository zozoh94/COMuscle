package COMuscle;

import java.util.ArrayList;

public class Jonction extends Emplacement {
    private ArrayList<Extremite> extremites;

    /* CONSTRUCTEUR */
    public Jonction(ArrayList<Extremite> extremites_) {
        this.longueur = 1;
        this.extremites = extremites_;
        
    	// On ajoute automatiquement les files des segments reliés
        for (int i = 0 ; i < extremites_.size() ; i++)
        	this.addFiles(extremites_.get(i).getSonSegment().getFiles());
    }
    
    /* GETTERS ET SETTERS */
    
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

package COMuscle;

import java.util.ArrayList;

public class Jonction extends Emplacement {

    /* CONSTRUCTEUR */
    public Jonction(ArrayList<Extremite> extremites) {
    	super(extremites);
    	
        this.longueur = 1;
        
    	// On ajoute automatiquement les files des segments reliés (c'est juste plus pratique que de le refaire à la main dans le main()...)
        for (int i = 0 ; i < extremites.size() ; i++)
        	this.addFiles(extremites.get(i).getSonSegment().getFiles());
    }
	
	public Emplacement recupererEmplacementSuivant(int sens) {
		return this.extremites.get(sens).getSonSegment();
	}
	
	
	
	public String toString() {
		return "Jct#" + this.getId();
	}
    
}

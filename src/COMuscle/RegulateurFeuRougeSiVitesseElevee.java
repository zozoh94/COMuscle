package COMuscle;

import java.util.ArrayList;

public class RegulateurFeuRougeSiVitesseElevee extends Regulateur{
	
	
	public RegulateurFeuRougeSiVitesseElevee(Semaphore s, CVitesse c) {
		c=(CVitesse) super.capteurs.get(0);
		s= super.semaphores.get(0);
	}
	
	
	public void run() {
		for(int i=0; i<super.capteurs.get(0).sonEmplacement.sesVehicules.size(); i++) {
			if (super.capteurs.get(0).sonEmplacement.sesVehicules.get(i).vitesse>50) 
				super.semaphores.get(0).etat=TricolorEnum.ROUGE;
		}
		
		
	}
	
}

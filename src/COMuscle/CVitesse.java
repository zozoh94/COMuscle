package COMuscle;

import java.util.ArrayList;

public class CVitesse extends Capteur {

	
	public CVitesse(Position p) {
		super(p);
	}
	
	public int signalerVitesse() {
		int vitesse =0;
		
		for(int i=0; i<this.saPosition.getEmplacement().getSesVehicules().size();i++) {
			if (this.saPosition.getEmplacement().getSesVehicules().get(i).getPosition().getPosition()==this.saPosition.getPosition())
				vitesse=this.saPosition.getEmplacement().getSesVehicules().get(i).getVitesse();
		}
		
		
		return vitesse;
		
	}
	
	
}
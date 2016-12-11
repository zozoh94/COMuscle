package COMuscle;

import java.util.ArrayList;

public class CVitesse extends Capteur {

	
	public CVitesse(Position p) {
		super(p);
	}
	
	public int signalerVitesse() {
		int vitesse =0;
		ArrayList<Vehicule> av = new ArrayList<Vehicule>();
		for(Vehicule v : super.saPosition.getEmplacement().getSesVehicules()) {
			av.add(v);
			
		}
		for (int i=0; i<av.size();i++) {
			if (super.saPosition.getPosition()==av.get(i).position.getPosition()) 
				vitesse = av.get(i).vitesse;
			
		}
		System.out.println("la vitesse de la voiture est : " + vitesse);
		
		return vitesse;
		
	}
	@Override
	public String toString() {
		return "";
	}
	
}
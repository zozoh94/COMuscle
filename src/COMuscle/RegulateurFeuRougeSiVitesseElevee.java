package COMuscle;


public class RegulateurFeuRougeSiVitesseElevee extends Regulateur{
	private Feu f;
	private CVitesse cv;
	
	public RegulateurFeuRougeSiVitesseElevee(Feu f_, CVitesse cv_) {
		f=f_;
		cv=cv_;
	}
	
	public void run() {
		System.out.println("vitesse vehicule : " + cv.signalerVitesse());
	
				f.etat=EnumFeu.ROUGE;
		
	}
	
}

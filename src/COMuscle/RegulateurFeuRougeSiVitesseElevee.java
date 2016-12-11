package COMuscle;


public class RegulateurFeuRougeSiVitesseElevee extends Regulateur{
	private Feu f;
	private CVitesse cv;
	
	public RegulateurFeuRougeSiVitesseElevee(Feu f_, CVitesse cv_) {
		f=f_;
		cv=cv_;
	}
	
	public void run() {
		if (cv.signalerVitesse()>=1) 
				f.etat=EnumFeu.ROUGE;
		
	}
	
}

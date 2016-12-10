package COMuscle;

import java.util.ArrayList;
import java.util.Arrays;

public class JonctionSimple extends Jonction {

	public JonctionSimple(Extremite extremite1, Extremite extremite2) {
		super(new ArrayList<Extremite>(Arrays.asList(extremite1, extremite2)));
	}
    
    public JonctionSimple(Segment segment1, Segment segment2) {
    	super(new ArrayList<Extremite>(Arrays.asList(segment1.getExtremite2(), segment2.getExtremite1())));
    }

}

package COMuscle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	
    	// Cr�ation du r�seau routier
    	Segment segment1 = new Segment(true);
    	Segment segment2 = new Segment(true);
    	
    	JonctionSimple jonction1 = new JonctionSimple(segment1, segment2);
    	
    }
}

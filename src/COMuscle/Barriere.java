package COMuscle;

import java.util.ArrayList;
import java.util.Arrays;

public class Barriere extends Jonction {

	public Barriere(Extremite extremite) {
		super(new ArrayList<Extremite>(Arrays.asList(extremite)));
	}

}

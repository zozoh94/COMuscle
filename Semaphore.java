package COMuscle;

public abstract class Semaphore {
	protected Extremite sonExtremite;
	
	public Extremite getSonExtremite() {
		return sonExtremite;
	}
	
	public void setSonExtremite(Extremite e) {
		sonExtremite=e;
	}
}
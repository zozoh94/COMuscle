package COMuscle;

public abstract class Semaphore {
	protected Extremite sonExtremite;
	
	public Semaphore() {
	}
	
	public Semaphore(Extremite extremite) {
		sonExtremite = extremite;
	}
	
	public Extremite getSonExtremite() {
		return sonExtremite;
	}
	
	public void setSonExtremite(Extremite e) {
		sonExtremite = e;
	}
}
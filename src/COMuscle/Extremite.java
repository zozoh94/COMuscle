package COMuscle;

import java.util.ArrayList;

public class Extremite {
  private Jonction saJonction;
  private Segment sonSegment;
  private ArrayList<Semaphore> sesSemaphores;
  

	public Extremite() {
		super();
	}
	
	public Extremite(Segment sonSegment) {
		super();
		this.sonSegment = sonSegment;
	}
  
	public Extremite(Jonction saJonction, Segment sonSegment, ArrayList<Semaphore> sesSemaphores) {
		super();
		this.saJonction = saJonction;
		this.sonSegment = sonSegment;
		this.sesSemaphores = sesSemaphores;
	}

/* GETTERS ET SETTERS */
  
  public ArrayList<Semaphore> getSesSemaphores() {
	  return sesSemaphores;
  }
  
  public void setSesSemaphores(ArrayList<Semaphore> s) {
	  sesSemaphores=s;
  }
  
  public Jonction getSaJonction() {
    return saJonction;
  }
  
  public void setSaJonction(Jonction saJonction_) {
    this.saJonction = saJonction_;
  }
  
  public Segment getSonSegment() {
    return sonSegment;
  }
  
  public void setSonSegment(Segment sonSegment_) {
    this.sonSegment = sonSegment_;
}
}
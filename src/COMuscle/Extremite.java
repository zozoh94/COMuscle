package COMuscle;

import java.util.ArrayList;

public class Extremite {
  private Jonction saJonction;
  private Segment sonSegment;
  private ArrayList<Semaphore> sesSemaphore;
  
  /* GETTERS ET SETTERS */
  
  public ArrayList<Semaphore> getSonSemaphore() {
	  return sesSemaphore;
  }
  
  public void setSonSemaphore(ArrayList<Semaphore> s) {
	  sesSemaphore=s;
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
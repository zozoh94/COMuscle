package COMuscle;

public class Extremite {
  private Jonction saJonction;
  private Segment sonSegment;
  
  /* GETTERS ET SETTERS */
  
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

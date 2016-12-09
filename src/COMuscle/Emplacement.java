package COMuscle;

public abstract class Emplacement {
  protected int longueur;
  protected Capteur sonCapteur;
  
  /* GETTERS ET SETTERS */
  
  public Capteur getSonCapteur(){
    return sonCapteur;
  }
  
  public void setSonCapteur(Capteur capteur) {
    this.sonCapteur = capteur;
  }
  
  public int getLongueur() {
    return longueur;
  }
  
  public void setLongueur(int longueur_) {
    this.longueur = longueur_;
  }
}

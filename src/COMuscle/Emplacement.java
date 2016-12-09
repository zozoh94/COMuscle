package COMuscle;

public abstract class Emplacement {
  protected int longueur;
  
  /* GETTERS ET SETTERS */
  
  public int getLongueur() {
    return longueur;
  }
  
  public void setLongueur(int longueur_) {
    this.longueur = longueur_;
  }
}

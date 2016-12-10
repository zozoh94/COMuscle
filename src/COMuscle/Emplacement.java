package COMuscle;

import java.util.ArrayList;

public abstract class Emplacement {
  protected int longueur;
  protected Capteur sonCapteur;
  protected ArrayList<Vehicule> sesVehicules;
  
  /* GETTERS ET SETTERS */
  
  public ArrayList<Vehicule> getSesVehicules() {
      return sesVehicules;
  }
    
  public void setSesVehicules(ArrayList<Vehicule> sesVehicules_) {
      this.sesVehicules = sesVehicules_;
  }
    
  public void addVehicule(Vehicule vehicule) {
      this.sesVehicules.add(vehicule);
  }

  public void removeVehicule(Vehicule vehicule) {
      this.sesVehicules.remove(vehicule);
  }

  /*public Emplacement getEmplacement() {
      return emplacement;
  }

  public void setEmplacement(Emplacement emplacement) {
      this.emplacement = emplacement;
  }*/
  
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

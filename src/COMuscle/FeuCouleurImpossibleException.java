package COMuscle;

public class FeuCouleurImpossibleException extends Exception {
    public FeuCouleurImpossibleException() {
        super("Ce feu n'accepte pas ce type de couleur.");
    }
}

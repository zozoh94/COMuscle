package COMuscle;

import java.lang.Exception;

public class DemiTourImpossibleException extends Exception {
    public DemiTourImpossibleException() {
        super("Le véhicule n'a pas pu faire demi-tour il est bloqué.");
    }
}

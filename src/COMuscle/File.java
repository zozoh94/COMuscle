package COMuscle;

public class File {
	private Emplacement emplacement;
	private int sens; // Correspond � l'extr�mit� de sortie (si sens vers extr�mit� 0, sens 0, si extr�mit� 1, sens = 1)
	
	public File(int sens) {
		this.sens = sens;
	}
	
	public int getSens() {
		return this.sens;
	}
	
	public String toString() {
		return "" + sens;
	}
}

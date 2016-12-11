package COMuscle;

public class File {
	private Emplacement emplacement;
	private int sens; // Correspond à l'extrémité de sortie (si sens vers extrémité 0, sens 0, si extrémité 1, sens = 1)
	
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

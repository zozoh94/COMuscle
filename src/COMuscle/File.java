package COMuscle;

public class File {
	private Emplacement emplacement;
	private int sens; // Correspond à l'extrémité de sortie (si sens vers extrémité 0, sens 0, si extrémité 1, sens = 1)

	private static File File1 = null;
	private static File File2 = null;

	private File(int sens) {
		this.sens = sens;
	}

	public static File getFile1() {
		if(File1 == null)
			File1 = new File(0);
		return File1;
	}

	public static File getFile2() {
		if(File2 == null)
			File2 = new File(1);
		return File2;
	}
	
	public int getSens() {
		return this.sens;
	}
	
	public String toString() {
		return "" + sens;
	}
}

package COMuscle;

public class Position {
	private Emplacement emplacement;
	private int position;
	private File file;
	
	public Position (Emplacement emplacement) {
		this.emplacement = emplacement;
		this.position = 0;
	}
	
	public Position (Emplacement emplacement, File file) {
		this(emplacement);
		this.file = file;
	}
	
	public Position (Emplacement emplacement, int position, File file) {
		this.emplacement = emplacement;
		this.file = file;
		this.position = 0;
	}

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String toString() {
		return "pos[" + this.emplacement + "," + this.position + "," + this.file + "]";
	}
	
}

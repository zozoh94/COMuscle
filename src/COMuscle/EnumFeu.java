package COMuscle;

public enum EnumFeu {
	ROUGE("rouge"),
	ORANGE("orange"),
	VERT("vert");
	
	
	private String name = "";
	
	 EnumFeu(String etat) {
		name=etat;
	}
	
	 public String toString() {
		 return name;
	 }
}

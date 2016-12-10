package COMuscle;

public enum TricolorEnum {
	ROUGE("rouge"),
	ORANGE("orange"),
	VERT("vert");
	
	private String name = "";
	
	 TricolorEnum(String etat) {
		name=etat;
	}
	
	 public String toString() {
		 return name;
	 }
}


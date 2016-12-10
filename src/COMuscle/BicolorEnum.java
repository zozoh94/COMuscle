package COMuscle;

public enum BicolorEnum {
	ROUGE("rouge"),
	VERT("vert");
	
	private String name = "";
	
	 BicolorEnum(String etat) {
		name=etat;
	}
	
	 public String toString() {
		 return name;
	 }
}

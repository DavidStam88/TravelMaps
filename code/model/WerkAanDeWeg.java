package model;

public class WerkAanDeWeg extends Status {
	private int vertragingTijd;
	
	public WerkAanDeWeg(int vertragingTijd){
		this.vertragingTijd = vertragingTijd;
	}
	
	public int getVertragingTijd(){
		return this.vertragingTijd;
	}
	
	public String toString(){
		return "Kent wegwerkzaamheden met een vertraging van: " + this.vertragingTijd;
	}
}

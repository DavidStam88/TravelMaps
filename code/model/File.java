package model;

public class File extends Status {
	private Vertraging vertraging;
	
	public File(Vertraging vertraging){
		this.vertraging = vertraging;
	}
	
	public Vertraging getVertraging(){
		return this.vertraging;
	}
	
	public String toString(){
		return "Kent een file met een vertraging van: " + this.vertraging;
	}
}

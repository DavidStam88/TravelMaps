package model;

public class RouteDeel {
	private VerbindingStuk verbindingStuk;
	private int deelNummer;
	
	public RouteDeel(VerbindingStuk verbindingStuk, int deelNummer){
		this.verbindingStuk = verbindingStuk;
		this.deelNummer = deelNummer;
	}
	
	public boolean checkOfRouteDeelMogelijk(){
		return false;
	}
	
	public int getDeelNummer(){
		return this.deelNummer;
	}
	
	public VerbindingStuk getVerbindingStuk(){
		return this.verbindingStuk;
	}
	
	public String toString(){
		return "Routedeel: " + this.deelNummer + " " + this.verbindingStuk + "\n";
	}
}

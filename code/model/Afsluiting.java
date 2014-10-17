package model;

public class Afsluiting extends Status {
	private double tijdVanaf;
	private double tijdTot;
	
	public Afsluiting(double tijdVanaf, double tijdTot){
		this.tijdVanaf = tijdVanaf;
		this.tijdTot = tijdTot;
	}

	public double getTijdVanaf() {
		return tijdVanaf;
	}

	public double getTijdTot() {
		return tijdTot;
	}
	
	public String toString(){
		return "Afgesloten tussen " + tijdVanaf + "0 uur en " + tijdTot + "0 uur";
	}
}

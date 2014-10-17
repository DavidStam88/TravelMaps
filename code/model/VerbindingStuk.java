package model;

import java.util.ArrayList;

public class VerbindingStuk {
	private String naam;
	private Plaats van;
	private Plaats naar;
	private int reistijd;
	private ArrayList statussen = new ArrayList <Status>();
	
	public VerbindingStuk(String naam, Plaats van, Plaats naar, int reistijd){
		this.naam = naam;
		this.reistijd = reistijd;
		this.van = van;
		this.naar = naar;
	}

	public void addStatus(Status status){
		statussen.add(status);
	}
	
	public String getNaam(){
		return this.naam;
	}
	
	public int getReistijd(){
		return this.reistijd;
	}
	
	public int berekenVertragingTijd(){
		int vertragingtijd = 0;
		for (int i=0; i<statussen.size(); i++){
			if (statussen.get(i) instanceof File){
				Vertraging vertraging = ((File) statussen.get(i)).getVertraging();
				vertragingtijd += vertraging.getVertragingTijd();
			}
			else if (statussen.get(i) instanceof WerkAanDeWeg){
				vertragingtijd += ((WerkAanDeWeg) statussen.get(i)).getVertragingTijd();
			}
		}
		return vertragingtijd;
	}
	
	public boolean checkOpAfsluiting(){
		boolean afsluiting = false;
		for (int i = 0; i<statussen.size(); i++){
			if (statussen.get(i) instanceof Afsluiting){
				afsluiting = true;
			}
		}
		return afsluiting;
	}
	
	public ArrayList getStatussen(){
		return this.statussen;
	}
	
	public String toString(){
		return this.naam + " " + this.statussen + " Totale vertragingtijd: " + this.berekenVertragingTijd();
	}

}

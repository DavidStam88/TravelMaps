package model;

import java.util.ArrayList;

public class Route {
	private Plaats van;
	private Plaats naar;
	private ArrayList routeDelen = new ArrayList<RouteDeel>();
	
	public Route(Plaats van, Plaats naar){
		this.van = van;
		this.naar = naar;
	}
	
	public void addRouteDeel(RouteDeel routeDeel){
		routeDelen.add(routeDeel);
	}
	
	public Plaats getBeginPlaats(){
		return this.van;
	}
	
	public Plaats getEindPlaats(){
		return this.naar;
	}
	
	public int berekenTotaleRouteTijd(){
		int totaleRouteTijd = 0;
		for(int i=0; i<routeDelen.size(); i++){
			VerbindingStuk verbinding = ((RouteDeel) routeDelen.get(i)).getVerbindingStuk();
			totaleRouteTijd += verbinding.getReistijd();
		}
		return totaleRouteTijd;
	}

	public int berekenTotaleVertragingTijd(){
		int totaleVertragingTijd = 0;
		for(int i=0; i<routeDelen.size(); i++){
			VerbindingStuk verbinding = ((RouteDeel) routeDelen.get(i)).getVerbindingStuk();
			totaleVertragingTijd += verbinding.berekenVertragingTijd();
		}
		return totaleVertragingTijd;
	}
	
	public boolean checkOpAfsluitingen(){
		for(int i=0; i<routeDelen.size(); i++){
			VerbindingStuk verbinding = ((RouteDeel) routeDelen.get(i)).getVerbindingStuk();
			if (verbinding.checkOpAfsluiting()){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<RouteDeel> getRouteDelen(){
		return this.routeDelen;
	}
	
	public String toString(){
		return "Totale reistijd: " + (this.berekenTotaleRouteTijd() + this.berekenTotaleVertragingTijd()) + " minuten. \n"  + this.routeDelen;
	}

}

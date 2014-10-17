package travelMaps;

import java.util.ArrayList;

import model.*;
import verkeersData.*;

public class TravelMaps {
	public static void main(String[] args){
		VerkeersData vD = new VerkeersData();
		
		String beginplaats = "Arnhem";
		String eindplaats = "Amsterdam";
		
		ArrayList routes = vD.getRoutes(beginplaats, eindplaats);
		toonRoutes(routes);
	}
	
	public static void toonRoutes(ArrayList<Route> routes){
		for (int i=0; i<routes.size(); i++){
			if (routes.get(i).checkOpAfsluitingen()){
				toonWaarschuwing();
			}
			System.out.println(routes.get(i));
		}
	}
	
	public static void toonWaarschuwing(){
		System.out.println("Let op: Deze route kent verbindingstukken die tussen bepaalde tijden afgesloten zijn!");
	}
}

package verkeersData;

import java.util.ArrayList;

import model.Afsluiting;
import model.File;
import model.Plaats;
import model.Route;
import model.RouteDeel;
import model.Status;
import model.VerbindingStuk;
import model.Vertraging;
import model.WerkAanDeWeg;
import travelMaps.*;

public class VerkeersData {
	
	private ArrayList<Route> routes = new ArrayList<Route>();
	private ArrayList<Plaats> plaatsen = new ArrayList<Plaats>();
	private ArrayList<VerbindingStuk> verbindingStukken = new ArrayList<VerbindingStuk>();
	
	public VerkeersData(){
		maakPlaatsen();
		maakVerbindingStukken();
		maakStatussen();
		maakRoutes();
	}
	
	private void maakRoutes(){
		Route NijmegenArnhem = new Route(plaatsen.get(0), plaatsen.get(1));
		Route ArnhemZwolle = new Route(plaatsen.get(1), plaatsen.get(2));
		Route ArnhemAmsterdam = new Route(plaatsen.get(1), plaatsen.get(5));
		Route EdeAmsterdam = new Route(plaatsen.get(3), plaatsen.get(5));
		
		RouteDeel NijmegenArnhem1 = new RouteDeel(verbindingStukken.get(0), 1);
		
		RouteDeel EdeAmsterdam1 = new RouteDeel(verbindingStukken.get(9), 1);

		RouteDeel ArnhemZwolle1 = new RouteDeel(verbindingStukken.get(3), 1);
		RouteDeel ArnhemAmsterdam1 = new RouteDeel(verbindingStukken.get(5), 1);
		RouteDeel ArnhemAmsterdam2 = new RouteDeel(verbindingStukken.get(6), 2);
		RouteDeel ArnhemAmsterdam3 = new RouteDeel(verbindingStukken.get(7), 3);
		
		NijmegenArnhem.addRouteDeel(NijmegenArnhem1);
		
		ArnhemZwolle.addRouteDeel(ArnhemZwolle1);
		
		ArnhemAmsterdam.addRouteDeel(ArnhemAmsterdam1);
		ArnhemAmsterdam.addRouteDeel(ArnhemAmsterdam2);
		ArnhemAmsterdam.addRouteDeel(ArnhemAmsterdam3);
		
		EdeAmsterdam.addRouteDeel(EdeAmsterdam1);
		
		routes.add(EdeAmsterdam);
		routes.add(NijmegenArnhem);
		routes.add(ArnhemZwolle);
		routes.add(ArnhemAmsterdam);
	}
	
	private void maakStatussen(){
		Vertraging vertraging1 = new Vertraging(30);
		Status file1 = new File(vertraging1);
		Status werkAanDeWeg1 = new WerkAanDeWeg(60);
		Status afsluiting1 = new Afsluiting(12.00, 15.00);
		
		Vertraging vertraging2 = new Vertraging(50);
		Status file2 = new File(vertraging2);
		Status werkAanDeWeg2 = new WerkAanDeWeg(20);
		Status afsluiting2 = new Afsluiting(09.00, 23.00);
		
		verbindingStukken.get(0).addStatus(file1);
		verbindingStukken.get(2).addStatus(werkAanDeWeg1);
		verbindingStukken.get(4).addStatus(afsluiting1);

		verbindingStukken.get(3).addStatus(file2);
		verbindingStukken.get(6).addStatus(werkAanDeWeg2);
		verbindingStukken.get(9).addStatus(afsluiting2);
	}
	
	private void maakVerbindingStukken(){
		VerbindingStuk A1 = new VerbindingStuk("A1", plaatsen.get(0), plaatsen.get(1), 10);
		VerbindingStuk B1 = new VerbindingStuk("B1", plaatsen.get(1), plaatsen.get(0), 10);
		VerbindingStuk A2 = new VerbindingStuk("A2", plaatsen.get(1), plaatsen.get(2), 30);
		VerbindingStuk B2 = new VerbindingStuk("B2", plaatsen.get(2), plaatsen.get(1), 30);
		VerbindingStuk A3 = new VerbindingStuk("A3", plaatsen.get(2), plaatsen.get(3), 40);
		VerbindingStuk B3 = new VerbindingStuk("B3", plaatsen.get(3), plaatsen.get(2), 40);
		VerbindingStuk A4 = new VerbindingStuk("A4", plaatsen.get(3), plaatsen.get(4), 60);
		VerbindingStuk B4 = new VerbindingStuk("B4", plaatsen.get(4), plaatsen.get(3), 60);
		VerbindingStuk A5 = new VerbindingStuk("A5", plaatsen.get(4), plaatsen.get(5), 80);
		VerbindingStuk B5 = new VerbindingStuk("B5", plaatsen.get(5), plaatsen.get(4), 80);
		
		verbindingStukken.add(A1);
		verbindingStukken.add(A2);
		verbindingStukken.add(A3);
		verbindingStukken.add(A4);
		verbindingStukken.add(A5);
		verbindingStukken.add(B1);
		verbindingStukken.add(B2);
		verbindingStukken.add(B3);
		verbindingStukken.add(B4);
		verbindingStukken.add(B5);
	}
	
	private void maakPlaatsen(){
		Plaats Arnhem = new Plaats("Nijmegen");
		Plaats Nijmegen = new Plaats("Arnhem");
		Plaats Amsterdam = new Plaats("Zwolle");
		Plaats Utrecht = new Plaats("Ede");
		Plaats Ede = new Plaats("Utrecht");
		Plaats Zwolle = new Plaats("Amsterdam");
		
		plaatsen.add(Arnhem);
		plaatsen.add(Nijmegen);
		plaatsen.add(Amsterdam);
		plaatsen.add(Utrecht);
		plaatsen.add(Ede);
		plaatsen.add(Zwolle);
	}
	
	public ArrayList<Route> getRoutes(String a, String b){
		ArrayList<Route> mogelijkeRoutes = new ArrayList<Route>();
		for (int i=0; i< routes.size(); i++){
			if(routes.get(i).getBeginPlaats().getPlaatsNaam() ==  a && routes.get(i).getEindPlaats().getPlaatsNaam() == b){
				if (!routes.get(i).checkOpAfsluitingen()){
					mogelijkeRoutes.add(routes.get(i));
				}
			}
		}
		ArrayList<Route> mogelijkeGesorteerdeRoutes = zetBesteRouteBovenaan(mogelijkeRoutes);
		return mogelijkeRoutes;
	}
	
	private ArrayList<Route> zetBesteRouteBovenaan(ArrayList routes){
		for(int i=1; i<routes.size(); i++){
			if (((Route) routes.get(i)).berekenTotaleRouteTijd() + ((Route) routes.get(i)).berekenTotaleVertragingTijd() < ((Route)routes.get(0)).berekenTotaleRouteTijd() + ((Route)routes.get(0)).berekenTotaleVertragingTijd()){
				Route wissel = ((Route)routes.get(0));
				routes.set(0, routes.get(i));
				routes.set(i, wissel);
			}
		}
		return routes;
	}

}

package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.NoRouteException;


public class BiDirectionalRide extends TransportRide {
	private int currentLoc;
	private ArrayList<FunRide> route = new ArrayList<FunRide>();
	public BiDirectionalRide() {
		super();
	}
	public BiDirectionalRide(String name, int dur, int batch, 
			ArrayList<FunRide> locations) {
		super(name, dur, batch, locations);
		currentLoc = 0;
		
	}
	public final String getFullRoute() {
		String result = "The followed route is: ";
	
		ArrayList<FunRide> route = super.getRouteLocations();
		int i;
		if (route.size() == 2) {
			result += route.get(0).getName() + ", ";
			result += route.get(1).getName() + ", ";
			result += route.get(0).getName();
			return result;
		}
		if (route.size() == 1) {
			result += route.get(0).getName();
			return result;
		}
		
		for (i = 0; i < route.size(); i++) {
			result += route.get(i).getName() + ", "; 
		}
		i -= 2;
		for (int j = i; j > 0; j--) {
			result += route.get(j).getName() + ", ";
		}
		result += route.get(0).getName();
		return result;
		
	}
	public final void move() throws NoRouteException {
		if (getRouteLocations().isEmpty()) {
			throw new NoRouteException("no route specified");
		}
			int i;
			for (i = 0; i < getRouteLocations().size(); i++) {
				route.add(getRouteLocations().get(i));
			}
			i = i - 2;
		    for (int j = i; j > 0; j--) {
		    	route.add(getRouteLocations().get(j));
		    }
		  
		    currentLoc++;
		    FunRide loc = route.get(currentLoc);
		    if (currentLoc == route.size() - 1) {
		    	currentLoc = 1;
		    	route.clear();
		    }
		    for (int k = 0; k < loc.getCurrentAmusers().size(); k++) {
				 Amuser a = (Amuser) getCurrentAmusers().get(k);
				 a.move(loc); 
			 }
			 
		
			
		
	}
	
	public final FunRide getCurrentLocation() {
		if (currentLoc == 0) {
			return this.getRouteLocations().get(0);
		}
	else {
		return route.get(currentLoc);
	}
		
	}
	public final void setCurrentLoc(int loc) {
		currentLoc = loc;
	}
	
}
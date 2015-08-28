package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.exceptions.NoRouteException;




public class CircularRide extends TransportRide {
	public CircularRide() {
		super();
	}
	public CircularRide(String name, int dur, int batch, 
			ArrayList<FunRide> locations) {
		super(name, dur, batch, locations);
	}
	public final String getFullRoute() {
		 
		String result = "The followed route is: ";
		ArrayList<FunRide> route = super.getRouteLocations();
		
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
			 
		for (int i = 0; i < route.size(); i++) {
			
			result += route.get(i).getName() + ", "; 
			
		}
		
		result += route.get(0).getName();
		return result;
	}
	public final void move() throws NoRouteException {
	
	 super.move();
}
	
	
	
}
	 


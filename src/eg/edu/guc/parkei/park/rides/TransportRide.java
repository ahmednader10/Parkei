package eg.edu.guc.parkei.park.rides;


import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;

import eg.edu.guc.parkei.exceptions.NoRouteException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;




public abstract class TransportRide extends Ride {
	private ArrayList<FunRide> routeLocations;
	private int currentLocation;
	public TransportRide() {
		super();
	}
	public TransportRide(String name, int dur, int batch, 
			ArrayList<FunRide> locations) {
		super(name, dur, batch);
		
		
		
		
			routeLocations = locations;
		
	}
	public abstract String getFullRoute();
	
	
	
	 public final boolean board(Amuser amuser) throws CannotBoardException
	 , OutOfOrderException {
		 
		 if (getCurrentLocation() != null && amuser.getLocation() != null) {
			 return super.board(amuser);
		 }
		 else {
			 return false;
		 }
	 }
	 public void move() throws NoRouteException {
		 if (routeLocations == null || routeLocations.isEmpty()) {
				throw new NoRouteException("no route specified");
			}
	 
		 if (currentLocation == routeLocations.size() - 1) {
	 currentLocation = 0;
		 }
		 else {
			 currentLocation++;
		 }
	 FunRide loc = routeLocations.get(currentLocation);
	 ArrayList<Amuser> currentamusers = getCurrentAmusers();
	
	 for (int i = 0; i < currentamusers.size(); i++) {
		 Amuser a = (Amuser) currentamusers.get(i);
		 a.move(loc); 
	 }
	 
	 
	 
		 }
	 
	 
		 
	 
	 public final boolean start() throws CannotOperateException, WrongAgeException {
		 
		 
		 if (this.inMaintenance()) {
			 throw new OutOfOrderException("ride in maintenance");
		 }
		 if (routeLocations == null || routeLocations.isEmpty()) {
				throw new NoRouteException("no route specified");
			}
		 this.move();
		 return super.start();
	 }
	 public boolean availableForAll() {
		 return true;
	 }
	 public final ArrayList<FunRide> getRouteLocations() {
			return routeLocations;
		}
	
	 public FunRide getCurrentLocation() {
			return (FunRide) routeLocations.get(currentLocation);
		}
	 public final int getLocation() {
		 return currentLocation;
	 }
	public final void setRouteLocations(ArrayList<FunRide> locations) {
		routeLocations = locations;
		
	}
	 public final void setCurrentLoc(FunRide newLoc) {
		 currentLocation = routeLocations.indexOf(newLoc);
	 }
	 public final void setLoc(int i) {
		 currentLocation = i;
	 }
	

}

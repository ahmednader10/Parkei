package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;

import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;


import eg.edu.guc.parkei.exceptions.LocationException;
import eg.edu.guc.parkei.exceptions.NoRidersException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;


import eg.edu.guc.parkei.utilities.Effect;




public abstract class FunRide extends Ride {
	public FunRide() {
		super();
	}
	public FunRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
		
	}
	
	public boolean board(Amuser amuser) throws CannotBoardException,
	OutOfOrderException {
		if (this != amuser.getLocation()) {
			throw new LocationException("amuser not located at the ride ");
		}
		if (this.inMaintenance()) {
			throw new OutOfOrderException("ride in maintenance");
		}
	 if (eligibleToRide(amuser)) {
			return super.board(amuser);
		}
		
		
		return false;
	}
	
	public abstract boolean eligibleToRide(Amuser amuser) throws CannotBoardException; 
	public abstract ArrayList<Effect> affects(Amuser amuser);
		
	
	public final boolean start() throws CannotOperateException, WrongAgeException {
		
		ArrayList<Amuser> x = super.getCurrentAmusers();
		if (x.size() == 0) {
			throw new NoRidersException("ride is empty");
		}
		
			for (int i = 0; i < x.size(); i++) {
				ArrayList<Effect> effects = x.get(i).getEffects();
				effects.clear();
				this.affects(x.get(i));
			}
			return super.start();
		
		
	}
	public abstract boolean availableForAll(); 
		
}

package eg.edu.guc.parkei.park.rides;


import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.AlreadyBoardingException;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.CannotUnboardException;
import eg.edu.guc.parkei.exceptions.FullRideException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;


import eg.edu.guc.parkei.exceptions.OutOfOrderException;






public abstract class Ride {
	private String name;
	private int duration;
	private int batchSize;
	private ArrayList<Amuser> currentAmusers = new ArrayList<Amuser>();
	private int ridesToMaintain;
	
	public Ride() {
		
	}
	public Ride(String name, int duration, int batchSize) {
		this.name = name;
		this.duration = duration;
		this.batchSize = batchSize;
		ridesToMaintain = 10;
		
	}
	
	public boolean board(Amuser amuser) throws CannotBoardException, 
	OutOfOrderException  {
		boolean isRiding = amuser.isRiding();
		if (currentAmusers.size() == batchSize) {
			throw new FullRideException("Ride is Full");
		}
		if (isRiding) {
			throw new AlreadyBoardingException("amuser is already boarding ");
		}
		if (inMaintenance()) {
			throw new OutOfOrderException("ride in maintenance ");
		}
		
		
		currentAmusers.add(amuser);
		amuser.setRiding(true);
		
		return true;
		
		
		
		}

	public final void unBoard() {
		if (!currentAmusers.isEmpty()) {
		for (int i = 0; i < currentAmusers.size(); i++) {
			Amuser amuser = (Amuser) currentAmusers.get(i);
			amuser.setRiding(false);
			
		   
		}
		currentAmusers.clear();
		}
	}
	public final boolean unBoard(Amuser amuser) throws CannotUnboardException {
		if (!currentAmusers.contains(amuser)) {
			throw new CannotUnboardException("amuser not on board");
		}
		
			    
				amuser.setRiding(false);
				currentAmusers.remove(amuser);
				return true;
			
		
	}
		public boolean start()throws CannotOperateException, WrongAgeException {
			
				if (inMaintenance()) {
					throw new OutOfOrderException("ride in maintenance");
				}
			
		ridesToMaintain--;
		return true;
		
	}
	public final boolean inMaintenance() {
		return ridesToMaintain == 0;
			
	}
	public final void endMaintenance() {
		ridesToMaintain = 10;
	}
	public  abstract boolean availableForAll();
	public final String getName() {
		return name;
	}
	public final int getDuration() {
		return duration;
	}
	public final int getBatchSize() {
		return batchSize;
	}
	public final int getRidesToMaintain() {
		return ridesToMaintain;
	}
	public final ArrayList<Amuser> getCurrentAmusers() {
		return currentAmusers;
	}
	public final void setRidesToMaintain(int rides) {
		ridesToMaintain = rides;
	}
	public final void setName(String newName) {
		name = newName;
	}
	public final void setBatchSize(int size) {
		batchSize = size;
	}
	public final void setDuration(int time) {
		duration = time;
	}
	public final void setCurrentAmusers(ArrayList<Amuser> x) {
		currentAmusers = x;
	}

}


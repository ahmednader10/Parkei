package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Senior;


import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;
import eg.edu.guc.parkei.exceptions.UnsuitableHeightException;
import eg.edu.guc.parkei.utilities.Effect;

public class RollerCoaster extends FunRide {
	public RollerCoaster() {
		super();
	}
	public RollerCoaster(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}
	public final boolean eligibleToRide(Amuser amuser) throws CannotBoardException {
		if (amuser instanceof Kid && amuser.getHeight() <= 140) {
			throw new UnsuitableHeightException("Kid too short ");
		}
		if (amuser instanceof Baby || amuser instanceof Senior) {
			throw new UnsuitableAgeCategoryException("unsuitable age");
		}
		
			return true;
		

		
		
	}
	public final ArrayList<Effect> affects(Amuser amuser) {
		ArrayList<Effect> effects = amuser.getEffects();
		if (amuser instanceof Kid && amuser.getHeight() > 140) {
			
			effects.add(Effect.Sick);
			return effects;
		}
		
		if (amuser instanceof Adult) {
			effects.add(Effect.High);
			return effects;
			
		}
		
		
	
		return null;
	}
	public final boolean availableForAll() {
		return false;
	}
}

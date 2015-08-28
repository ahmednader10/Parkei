package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;

import eg.edu.guc.parkei.utilities.Effect;


public class ScareRide extends FunRide {
	public ScareRide() {
		super();
	}
	public ScareRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}
	public final boolean eligibleToRide(Amuser amuser) throws UnsuitableAgeCategoryException {
		if (amuser instanceof Baby || amuser instanceof Senior 
				|| amuser instanceof Kid) {
			throw new UnsuitableAgeCategoryException("unsuitable age");
		}
	
			return true;
		
	}
	public final ArrayList<Effect> affects(Amuser amuser) {
		ArrayList<Effect> effects = amuser.getEffects();
		
		if (amuser instanceof Adult) {
			effects.add(Effect.Scared);
			
		}
		if (amuser instanceof Baby || amuser instanceof Kid 
				|| amuser instanceof Senior) {
			return null;
		}
		return effects;
	}
	public final boolean availableForAll() {
		return false;
	}

}

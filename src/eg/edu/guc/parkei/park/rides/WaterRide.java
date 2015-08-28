package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;
import eg.edu.guc.parkei.utilities.Effect;

public class WaterRide extends FunRide {
	public WaterRide() {
		super();
	}
	public WaterRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}
	public final boolean eligibleToRide(Amuser amuser) throws UnsuitableAgeCategoryException {
		if (amuser instanceof Baby) {
			throw new UnsuitableAgeCategoryException("unsuitable age");
			
		}
		return true;
	}
	public final ArrayList<Effect> affects(Amuser amuser) {
		ArrayList<Effect> effects = amuser.getEffects();
		if (amuser instanceof Kid) {
			effects.add(Effect.Wet);
			effects.add(Effect.Thrilled);
		}
		if (amuser instanceof Adult) {
			effects.add(Effect.Wet);
			effects.add(Effect.Happy);
		}
		if (amuser instanceof Senior) {
			effects.add(Effect.Wet);
			effects.add(Effect.Angry);
		}
		if (amuser instanceof Baby) {
			return null;
		}
		return effects;
	}
	public final boolean availableForAll() {
		return false;
	}
	

}

package eg.edu.guc.parkei.park.rides;
import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.utilities.Effect;

public class FerrisWheel extends FunRide {
	
		public FerrisWheel() {
			super();
		}
		public FerrisWheel(String name, int duration, int batchSize) {
			super(name, duration, batchSize);
		}
		public final boolean eligibleToRide(Amuser amuser) {
			
			return true;
		}
		public final ArrayList<Effect> affects(Amuser amuser) {
			ArrayList<Effect> effects = amuser.getEffects();
			if (amuser instanceof Baby) {
				
				effects.add(Effect.Thrilled);
			}
			if (amuser instanceof Kid) {
				effects.add(Effect.Happy);
				
			}
			if (amuser instanceof Adult) {
				effects.add(Effect.Bored);
				
			}
			if (amuser instanceof Senior) {
				effects.add(Effect.Happy);
				
			}
			return effects;
		}
		public final boolean availableForAll() {
			return true;
		}
		

}

package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class FullRideException extends CannotBoardException {
	public FullRideException() {
		
	}
	public FullRideException(String m) {
		super(m);
	}

}

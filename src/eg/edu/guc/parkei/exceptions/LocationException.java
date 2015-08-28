package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class LocationException extends CannotBoardException {
	public LocationException() {
		
	}
	public LocationException(String m) {
		super(m);
	}

}

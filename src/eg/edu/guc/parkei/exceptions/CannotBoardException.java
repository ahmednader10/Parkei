package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotBoardException extends ParkeiException {
	public CannotBoardException() {
		
	}
	public CannotBoardException(String m) {
		super(m);
	}

}

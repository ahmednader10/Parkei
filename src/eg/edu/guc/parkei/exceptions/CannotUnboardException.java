package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotUnboardException extends ParkeiException {
	public CannotUnboardException() {
		
	}
	public CannotUnboardException(String m) {
		super(m);
	}

}

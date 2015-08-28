package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class WrongTicketException extends AmuserException {
	public WrongTicketException() {
		
	}
	public WrongTicketException(String m) {
		super(m);
	}

}

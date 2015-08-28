package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class WrongAgeException extends AmuserException {
	public WrongAgeException() {
		
	}
	public WrongAgeException(String m) {
		super(m);
	}

}

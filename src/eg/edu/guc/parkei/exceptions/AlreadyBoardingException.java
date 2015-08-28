package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class AlreadyBoardingException extends CannotBoardException {
	public AlreadyBoardingException() {
		
	}
	public AlreadyBoardingException(String m) {
		super(m);
	}

}

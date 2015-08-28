package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class NoRidersException extends CannotOperateException {
	public NoRidersException() {
		
	}
	public NoRidersException(String m) {
		super(m);
	}

}

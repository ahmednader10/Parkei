package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotOperateException extends ParkeiException {
	public CannotOperateException() {
		
	}
	public CannotOperateException(String m) {
		super(m);
	}

}

package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class OutOfOrderException extends CannotOperateException {
	public OutOfOrderException() {
		
	}
	public  OutOfOrderException(String m) {
		super(m);
	}

}

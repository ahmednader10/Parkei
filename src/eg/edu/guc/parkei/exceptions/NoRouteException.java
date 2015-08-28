package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class NoRouteException extends CannotOperateException {
	public NoRouteException() {
		
	}
	public NoRouteException(String m) {
		super(m);
	}

}

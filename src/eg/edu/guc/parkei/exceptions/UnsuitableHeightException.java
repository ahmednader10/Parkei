package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class UnsuitableHeightException extends CannotBoardException {
	public UnsuitableHeightException() {
		
	}
	public UnsuitableHeightException(String m) {
		super(m);
	}

}

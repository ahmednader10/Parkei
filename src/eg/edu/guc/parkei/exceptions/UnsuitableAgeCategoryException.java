package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class UnsuitableAgeCategoryException extends CannotBoardException {
	public UnsuitableAgeCategoryException() {
		
	}
	public UnsuitableAgeCategoryException(String m) {
		super(m);
	}

}

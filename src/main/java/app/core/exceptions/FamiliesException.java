package app.core.exceptions;

public class FamiliesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FamiliesException() {
	}

	public FamiliesException(String message) {
		super(message);
	}

	public FamiliesException(Throwable cause) {
		super(cause);
	}

	public FamiliesException(String message, Throwable cause) {
		super(message, cause);
	}

	public FamiliesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

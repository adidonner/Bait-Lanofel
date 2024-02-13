package app.core.exceptions;

public class CasualitiesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CasualitiesException() {
	}

	public CasualitiesException(String message) {
		super(message);
	}

	public CasualitiesException(Throwable cause) {
		super(cause);
	}

	public CasualitiesException(String message, Throwable cause) {
		super(message, cause);
	}

	public CasualitiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package app.core.exceptions;

public class MediasException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MediasException() {
	}

	public MediasException(String message) {
		super(message);
	}

	public MediasException(Throwable cause) {
		super(cause);
	}

	public MediasException(String message, Throwable cause) {
		super(message, cause);
	}

	public MediasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

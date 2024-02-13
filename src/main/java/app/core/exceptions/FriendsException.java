package app.core.exceptions;

public class FriendsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FriendsException() {
	}

	public FriendsException(String message) {
		super(message);
	}

	public FriendsException(Throwable cause) {
		super(cause);
	}

	public FriendsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FriendsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

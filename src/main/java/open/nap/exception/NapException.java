package open.nap.exception;

public class NapException extends RuntimeException {

	public NapException() {
		super();
	}

	public NapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NapException(String message, Throwable cause) {
		super(message, cause);
	}

	public NapException(String message) {
		super(message);
	}

	public NapException(Throwable cause) {
		super(cause);
	}

}

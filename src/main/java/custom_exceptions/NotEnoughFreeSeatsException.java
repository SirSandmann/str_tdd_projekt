package custom_exceptions;

public class NotEnoughFreeSeatsException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughFreeSeatsException() {
        super();
    }

	public NotEnoughFreeSeatsException(String message) {
        super(message);
    }

    public NotEnoughFreeSeatsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

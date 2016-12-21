package custom_exceptions;

public class NotUniqueIdentifierException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotUniqueIdentifierException() {
        super();
    }
	
	public NotUniqueIdentifierException(String message) {
        super(message);
    }

    public NotUniqueIdentifierException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

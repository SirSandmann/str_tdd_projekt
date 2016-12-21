package custom_exceptions;

public class CustomerSameNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerSameNameException() {
        super();
    }
	
	public CustomerSameNameException(String message) {
        super(message);
    }

    public CustomerSameNameException(String message, Throwable throwable) {
        super(message, throwable);
    }
	
}

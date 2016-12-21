package custom_exceptions;

public class EventSameDateAndTitleException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventSameDateAndTitleException() {
        super();
    }
	
	public EventSameDateAndTitleException(String message) {
        super(message);
    }

    public EventSameDateAndTitleException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

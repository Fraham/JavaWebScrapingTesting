package RealTimeTrainsWebScraping.Exception;

/**
 *
 * @author Graham
 */
public class UnKnownStationException extends Exception {
    
    public UnKnownStationException() {
    }

    public UnKnownStationException(String message) {
        super(message);
    }

    public UnKnownStationException(Throwable cause) {
        super(cause);
    }

    public UnKnownStationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

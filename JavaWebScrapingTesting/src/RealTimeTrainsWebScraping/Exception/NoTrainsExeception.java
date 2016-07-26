package RealTimeTrainsWebScraping.Exception;

/**
 *
 * @author Graham
 */
public class NoTrainsExeception extends Exception {
    
    public NoTrainsExeception() {
    }

    public NoTrainsExeception(String message) {
        super(message);
    }

    public NoTrainsExeception(Throwable cause) {
        super(cause);
    }

    public NoTrainsExeception(String message, Throwable cause) {
        super(message, cause);
    }
}

package pl.pingwit.pingwitdemospring.exception;

/**
 * @author Pavel Radkevich
 * @since 10.07.23
 */
public class PingwitNotFoundException extends RuntimeException {
    public PingwitNotFoundException(String message) {
        super(message);
    }
}

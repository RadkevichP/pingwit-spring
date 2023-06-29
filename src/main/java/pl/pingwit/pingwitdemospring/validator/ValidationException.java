package pl.pingwit.pingwitdemospring.validator;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}

package pl.pingwit.pingwitdemospring.exception;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
public class ValidationException extends RuntimeException {

    private final List<String> violations;

    public ValidationException(String message, List<String> violations) {
        super(message);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

    @Override
    public String toString() {
        return getMessage() + " : " +
                "violations=" + violations;
    }
}

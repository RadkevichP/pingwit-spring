package pl.pingwit.pingwitdemospring.config.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pingwit.pingwitdemospring.exception.PingwitNotFoundException;
import pl.pingwit.pingwitdemospring.exception.ValidationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Pavel Radkevich
 * @since 10.07.23
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PingwitNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(PingwitNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.toString());
    }

}

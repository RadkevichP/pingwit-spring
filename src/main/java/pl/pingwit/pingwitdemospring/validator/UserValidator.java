package pl.pingwit.pingwitdemospring.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.exception.ValidationException;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Component
public class UserValidator {

    public void validateUser(UserDTO userDTO) {
        if (!userDTO.getEmail().endsWith("@pingwit.pl")) {
            throw new ValidationException("User email should be on @pingwit.pl!");
        }
    }
}

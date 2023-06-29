package pl.pingwit.pingwitdemospring.validator;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Component
public class UserValidator {

    public void validateUser(UserDTO userDTO) {
        String name = userDTO.getName();
        if (name.length() == 0 || name.contains("\\d+")) {
            throw new ValidationException("Name is invalid!");
        }
    }
}

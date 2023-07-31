package pl.pingwit.pingwitdemospring.validator;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.exception.ValidationException;
import pl.pingwit.pingwitdemospring.repository.SpringDataUserRepository;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Component
public class UserValidator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");

    private final SpringDataUserRepository userRepository;

    public UserValidator(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUser(UserDTO userDTO) {

        List<String> violations = new ArrayList<>();

        validateLetterField(userDTO.getName(), "name", violations);
        validateLetterField(userDTO.getSurname(), "surname", violations);
        validatePhone(userDTO, violations);
        validateEmail(userDTO, violations);
        validateEmailUniqueness(userDTO, violations);

        if (!violations.isEmpty()) {
            throw new ValidationException("Provided user is invalid!" , violations);
        }

    }

    private void validateEmail(UserDTO userDTO, List<String> violations) {
        if (!EMAIL_PATTERN.matcher(userDTO.getEmail()).matches()) {
            violations.add(String.format("invalid email: %s", userDTO.getEmail()));
        }
    }

    private void validatePhone(UserDTO userDTO, List<String> violations) {
        if (!PHONE_NUMBER_PATTERN.matcher(userDTO.getPhone()).matches()) {
            violations.add(String.format("'%s' with value '%s' can contain only digits", "phone", userDTO.getPhone()));
        }
    }

    private void validateLetterField(String value, String fieldName, List<String> violations) {
        if (isBlank(value)) {
            violations.add("Name is blank");
        }
        if (!ONLY_LETTERS_PATTERN.matcher(value).matches()) {
            violations.add(String.format("%s can contain only letters: %s", fieldName, value));
        }
    }

    private void validateEmailUniqueness(UserDTO userDTO, List<String> violations) {
        List<User> allByEmail = userRepository.findAllByEmail(userDTO.getEmail());
        if (!allByEmail.isEmpty()) {
            violations.add(String.format("email %s is already used in the system. please choose a different one!", userDTO.getEmail()));
        }
    }

}


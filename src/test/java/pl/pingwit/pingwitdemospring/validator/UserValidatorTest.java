package pl.pingwit.pingwitdemospring.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.exception.ValidationException;
import pl.pingwit.pingwitdemospring.repository.SpringDataUserRepository;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Pavel Radkevich
 * @since 7.08.23
 */
class UserValidatorTest {

    private final SpringDataUserRepository userRepository = mock(SpringDataUserRepository.class);

    private final UserValidator target = new UserValidator(userRepository);

    @Test
    @DisplayName("Validation Error should not be thrown when input is valid")
    void shouldNotThrow_whenUserIsValid() {
        // given
        UserDTO valid = validUser();

        // when
        assertDoesNotThrow(() -> target.validateUser(valid));

        // then
    }

    @Test
    void shouldThrow_whenEmailInvalid() {
        // given
        UserDTO invalidEmailUser = invalidEmailUser();
        String expectedMessage = String.format("invalid email: %s", invalidEmailUser.getEmail());

        // when
        ValidationException validationException = assertThrows(ValidationException.class, () -> target.validateUser(invalidEmailUser));

        // then
        List<String> violations = validationException.getViolations();
        assertThat(violations).containsOnly(expectedMessage);
    }

    @Test
    void shouldThrow_whenEmailAlreadyUsed() {
        // given
        UserDTO user = validUser();

        when(userRepository.findAllByEmail("test@mail.com")).thenReturn(List.of(new User()));
        String expectedMessage = String.format("email %s is already used in the system. please choose a different one!", user.getEmail());

        // when
        ValidationException validationException = assertThrows(ValidationException.class, () -> target.validateUser(user));

        // then
        List<String> violations = validationException.getViolations();
        assertThat(violations).containsOnly(expectedMessage);
    }

    private UserDTO invalidEmailUser() {
        UserDTO dto = new UserDTO();
        dto.setName("TestName");
        dto.setSurname("TestSurname");
        dto.setEmail("unvalid_email");
        dto.setPhone("897898787");
        return dto;
    }

    private UserDTO validUser() {
        UserDTO dto = new UserDTO();
        dto.setName("TestName");
        dto.setSurname("TestSurname");
        dto.setEmail("test@mail.com");
        dto.setPhone("897898787");
        return dto;
    }

    // Maven Surefire Plugin

}

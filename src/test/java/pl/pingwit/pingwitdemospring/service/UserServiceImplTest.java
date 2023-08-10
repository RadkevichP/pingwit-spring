package pl.pingwit.pingwitdemospring.service;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.converter.UserConverter;
import pl.pingwit.pingwitdemospring.repository.PagingUserRepository;
import pl.pingwit.pingwitdemospring.repository.SpringDataUserRepository;
import pl.pingwit.pingwitdemospring.repository.model.User;
import pl.pingwit.pingwitdemospring.validator.UserValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author Pavel Radkevich
 * @since 10.08.23
 */
class UserServiceImplTest {

    private final SpringDataUserRepository userRepository = mock(SpringDataUserRepository.class);
    private final UserConverter userConverter = mock(UserConverter.class);
    private final UserValidator validator = mock(UserValidator.class);
    private final PagingUserRepository pagingUserRepository = mock(PagingUserRepository.class);

    private final UserService target = new UserServiceImpl(userRepository,
            userConverter,
            validator,
            pagingUserRepository);

    // BDT behavioural driven testing

    // CI continous integration / CD continious delivery

    @Test
    void shouldCreateUser() {
        // given
        UserDTO userDTO = new UserDTO();
        User userToSave = new User();
        User savedUser = new User(77);

        when(userConverter.convertToEntity(userDTO)).thenReturn(userToSave);
        when(userRepository.save(userToSave)).thenReturn(savedUser);

        // when
        Integer actualId = target.createUser(userDTO);

        // then
        verify(validator).validateUser(userDTO);
        verify(userConverter).convertToEntity(userDTO);

        assertThat(actualId).isEqualTo(savedUser.getId());
    }
}

package pl.pingwit.pingwitdemospring.service;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.converter.UserConverter;
import pl.pingwit.pingwitdemospring.repository.UserRepository;
import pl.pingwit.pingwitdemospring.repository.model.User;
import pl.pingwit.pingwitdemospring.validator.UserValidator;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserValidator validator;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, UserValidator validator) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.validator = validator;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        Collection<User> all = userRepository.getAll();
        return userConverter.convertToDto(all);
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userRepository.getById(id);
        return userConverter.convertToDto(user);
    }

    @Override
    public Integer createUser(UserDTO userToCreate) {
        validator.validateUser(userToCreate);
        User user = userConverter.convertToEntity(userToCreate);
        return userRepository.createUser(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserDTO> searchByName(String name) {
        List<User> users = userRepository.searchByName(name);
        return userConverter.convertToDto(users);
    }
}

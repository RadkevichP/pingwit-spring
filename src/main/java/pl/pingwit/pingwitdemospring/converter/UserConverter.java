package pl.pingwit.pingwitdemospring.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Component
public class UserConverter {

    public User convertToEntity(UserDTO source) {
        return new User(source.getId(),
                source.getName(),
                source.getSurname(),
                source.getEmail(),
                source.getPhone());
    }

    public UserDTO convertToDto(User source) {
        return convertUserToDto(source);
    }

    public List<UserDTO> convertToDto(Collection<User> source) {
        return source.stream()
                .map(this::convertUserToDto)
                .collect(Collectors.toList());
    }

    private UserDTO convertUserToDto(User source) {
        UserDTO result = new UserDTO();
        result.setId(source.id());
        result.setName(source.name());
        result.setSurname(source.surname());
        result.setEmail(source.email());
        result.setPhone(source.phone());
        return result;
    }


}

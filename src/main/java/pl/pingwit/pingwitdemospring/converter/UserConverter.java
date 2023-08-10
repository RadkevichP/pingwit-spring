package pl.pingwit.pingwitdemospring.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope("prototype")
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
                .toList();
    }

    private UserDTO convertUserToDto(User source) {
        UserDTO result = new UserDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSurname(source.getSurname());
        result.setEmail(source.getEmail());
        result.setPhone(source.getPhone());
        return result;
    }


}

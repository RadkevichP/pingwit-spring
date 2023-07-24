package pl.pingwit.pingwitdemospring.converter;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
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
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope("prototype")
public class UserConverter {

    private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

    private final String name;

    public UserConverter() {
        this.name = RandomStringUtils.randomAlphabetic(4);
        log.info(String.format("created object of type UserConverter with name: %s", name));
    }

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
        result.setId(source.getId());
        result.setName(source.getName());
        result.setSurname(source.getSurname());
        result.setEmail(source.getEmail());
        result.setPhone(source.getPhone());
        return result;
    }


}

package pl.pingwit.pingwitdemospring.dto;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
public record UserDto(Integer id, String name, String surname, String email, String phone) {
}

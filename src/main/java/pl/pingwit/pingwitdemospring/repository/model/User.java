package pl.pingwit.pingwitdemospring.repository.model;

/**
 * @author Pavel Radkevich
 * @since 8.06.23
 */
public record User(Integer id, String name, String surname, String email, String phone) {
}

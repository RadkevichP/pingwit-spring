package pl.pingwit.pingwitdemospring.service;

import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getById(Integer id);

    Integer createUser(UserDTO userDTO);

    void deleteById(Integer id);

    List<UserDTO> searchByName(String name);
}

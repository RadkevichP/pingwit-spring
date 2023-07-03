package pl.pingwit.pingwitdemospring.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.controller.dto.UserFilterDTO;
import pl.pingwit.pingwitdemospring.repository.model.User;
import pl.pingwit.pingwitdemospring.service.UserService;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
// SOLID
// CRUD
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/user")
    public List<UserDTO> searchByName(@RequestParam String name) {
        return userService.searchByName(name);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Integer createUser(@RequestBody UserDTO userToCreate) {
        return userService.createUser(userToCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO userToUpdate) {
        return userService.updateUser(id, userToUpdate);
    }

    @PostMapping("/search")
    public List<UserDTO>  search(@RequestBody UserFilterDTO filter) {
        return userService.search(filter);
    }

}

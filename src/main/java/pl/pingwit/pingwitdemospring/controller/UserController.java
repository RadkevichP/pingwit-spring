package pl.pingwit.pingwitdemospring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdemospring.controller.dto.UserDTO;
import pl.pingwit.pingwitdemospring.controller.dto.UserFilterDTO;
import pl.pingwit.pingwitdemospring.service.UserService;

import java.util.List;


/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
@Tag(name = "User management API", description = "API for CRUD operations with users")
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(description = "Get user by user id. If user not found 404 status code is returned")
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/user")
    public List<UserDTO> searchByName(@RequestParam String name) {
        return userService.searchByName(name);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<UserDTO> getAll() {
        LOGGER.debug("пришел запрос на получение всех юзеров!");
        return userService.getAllUsers();
    }

    @Operation(description = "Create a new user. Only user with admin rights can use it")
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
    public List<UserDTO> search(@RequestBody UserFilterDTO filter) {
        return userService.search(filter);
    }

    @GetMapping("/page")
    public Page<UserDTO> getPaged(Pageable pageable) {
        return userService.getPage(pageable);
    }

}

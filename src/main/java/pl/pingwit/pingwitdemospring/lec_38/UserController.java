package pl.pingwit.pingwitdemospring.lec_38;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdemospring.lec_37.User;

import java.util.Collection;

/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.getById(id);
    }

    @GetMapping
    public Collection<User> getAll(){
        return userRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        userRepository.delete(id);
        return "OK";
    }

}

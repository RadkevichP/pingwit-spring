package pl.pingwit.pingwitdemospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdemospring.controller.dto.JokeDto;
import pl.pingwit.pingwitdemospring.service.JokeService;

/**
 * @author Pavel Radkevich
 * @since 24.07.23
 */
@RestController
@RequestMapping("/random-joke")
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public JokeDto getRandomJoke() {
        return jokeService.findRandomJoke();
    }

}

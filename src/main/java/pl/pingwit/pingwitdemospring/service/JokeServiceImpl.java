package pl.pingwit.pingwitdemospring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pingwit.pingwitdemospring.controller.dto.JokeDto;
import pl.pingwit.pingwitdemospring.integration.model.Joke;

/**
 * @author Pavel Radkevich
 * @since 24.07.23
 */
@Service
public class JokeServiceImpl implements JokeService {

    private static final String JOKE_PROVIDER_URL = "https://official-joke-api.appspot.com/random_joke";

    @Override
    public JokeDto findRandomJoke() {

        RestTemplate restTemplate = new RestTemplate();
        Joke result = restTemplate.getForObject(JOKE_PROVIDER_URL, Joke.class);

        return new JokeDto(result.getSetup(), result.getPunchline());
    }
}

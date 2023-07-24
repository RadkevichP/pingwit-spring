package pl.pingwit.pingwitdemospring.service;

import pl.pingwit.pingwitdemospring.controller.dto.JokeDto;

/**
 * @author Pavel Radkevich
 * @since 24.07.23
 */
public interface JokeService {

    JokeDto findRandomJoke();
}

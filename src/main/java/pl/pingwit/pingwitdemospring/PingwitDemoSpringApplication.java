package pl.pingwit.pingwitdemospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PingwitDemoSpringApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingwitDemoSpringApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Приложение стартует!");
        SpringApplication.run(PingwitDemoSpringApplication.class, args);
        LOGGER.info("Privet!");
    }

}

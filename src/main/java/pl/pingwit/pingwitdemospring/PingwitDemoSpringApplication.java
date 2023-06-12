package pl.pingwit.pingwitdemospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import pl.pingwit.pingwitdemospring.lec_37.point_2.repository.ProductRepository;

@SpringBootApplication
public class PingwitDemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingwitDemoSpringApplication.class, args);
    }

}

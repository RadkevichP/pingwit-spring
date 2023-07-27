package pl.pingwit.pingwitdemospring.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pavel Radkevich
 * @since 27.07.23
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("pradkevich@pingwit.pl");
        contact.setName("Pavel Radkevich");
        contact.setUrl("https://github.com/RadkevichP/");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Pingwit Shop API")
                .version("1.0")
                .contact(contact)
                .description("API for Pingwit Shop System")
                .license(mitLicense);

        return new OpenAPI().info(info);
    }
}

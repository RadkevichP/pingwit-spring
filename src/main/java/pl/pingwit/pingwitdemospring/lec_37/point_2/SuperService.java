package pl.pingwit.pingwitdemospring.lec_37.point_2;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.lec_37.point_2.repository.ProductRepository;

/**
 * @author Pavel Radkevich
 * @since 12.06.23
 */
@Component
public class SuperService {

    private final PingwitShopService pingwitShopService;
    private final ApplicationContext applicationContext;

    public SuperService(PingwitShopService pingwitShopService, ApplicationContext applicationContext) {
        this.pingwitShopService = pingwitShopService;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);

        pingwitShopService.printProducts();
        pingwitShopService.printUsers();
    }

}


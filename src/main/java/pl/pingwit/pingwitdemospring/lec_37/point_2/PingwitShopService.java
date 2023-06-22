package pl.pingwit.pingwitdemospring.lec_37.point_2;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.lec_37.Product;
import pl.pingwit.pingwitdemospring.lec_37.User;
import pl.pingwit.pingwitdemospring.lec_37.point_2.repository.ProductRepository;
import pl.pingwit.pingwitdemospring.lec_37.point_2.repository.UserRepository;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 12.06.23
 */

public class PingwitShopService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public PingwitShopService(
            UserRepository userRepository,
            ProductRepository productRepository
    ) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void printProducts() {
        List<Product> allProducts = productRepository.findAllProducts();
        allProducts.forEach(System.out::println);
    }

    public void printUsers() {
        List<User> allUsers = userRepository.findAllUsers();
        allUsers.forEach(System.out::println);
    }
}

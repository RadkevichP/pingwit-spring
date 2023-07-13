package pl.pingwit.pingwitdemospring.converter;


import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.ProductDTO;
import pl.pingwit.pingwitdemospring.repository.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public Product convertToEntity(ProductDTO source) {
        return new Product(source.getId(),
                source.getName(),
                source.getDescription(),
                source.getPrice());
    }

    public ProductDTO convertToDto(Product source) {
        return convertProductToDto(source);

    }

    public List<ProductDTO> convertToDto(Collection<Product> source) {
        return source.stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toList());


    }

    public ProductDTO convertProductToDto(Product source) {
        ProductDTO result = new ProductDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setPrice(source.getPrice());
        return result;
    }

}

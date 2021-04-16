package mini.mappers;

import mini.dtos.ProductDTO;
import mini.models.Product;

public class ProductMapper {
    public static Product unpackProduct(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(),
                productDTO.getImage(), productDTO.getCategory(), productDTO.getIdentifier());
    }
}

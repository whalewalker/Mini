package mini.services;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.models.Product;
import mini.models.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductService{
    void addProduct(ProductDTO productDTO) throws ProductException;
    Long count();
    void removeProduct(String identifier);
    void removeAllProduct();
    List<Product> getAllProduct();
    Product updateProduct(String identifier, ProductDTO productDTO) throws ProductException;
    List<Product> getAllProductsInCategory(ProductCategory category) throws ProductException;
    List<Product> getAllProductWithNameContaining(String productName);
    Product findProductById(String productId) throws ProductException;
}

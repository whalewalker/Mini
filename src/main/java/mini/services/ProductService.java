package mini.services;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;

public interface ProductService{
    void addProduct(ProductDTO productDTO) throws ProductException;
    Long count();
}

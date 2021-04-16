package mini.services;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.exceptions.RegisterUserException;
import mini.mappers.ProductMapper;
import mini.models.Product;
import mini.models.User;
import mini.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProduct(ProductDTO productDTO) throws ProductException {
        Product productToSave = ProductMapper.unpackProduct(productDTO);
        Optional<Product> product = productRepository.findById(productToSave.getIdentifier());
        if(product.isPresent()) throw new ProductException("Product already exist");
        save(productToSave);
    }

    private void save(Product productToSave) {
        productRepository.save(productToSave);
    }

    public Long count(){
        return productRepository.count();
    }

}

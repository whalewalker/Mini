package mini.services;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.mappers.ProductMapper;
import mini.models.Product;
import mini.models.ProductCategory;
import mini.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public void removeProduct(String identifier) {
        deleteProductFromDb(identifier);
    }

    @Override
    public void removeAllProduct() {
        deleteAllProductFromDb();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(String identifier, ProductDTO productDetails) throws ProductException {
        Product productToUpdate = findProductByIdentifier(identifier);
        if(!productToUpdate.getName().equals(productDetails.getName())){
            productToUpdate.setName(productDetails.getName());
        }
        if(!productToUpdate.getDescription().equals(productDetails.getDescription())){
            productToUpdate.setDescription(productDetails.getDescription());
        }
        if(!productToUpdate.getCategory().equals(productDetails.getCategory())){
            productToUpdate.setCategory(productDetails.getCategory());
        }
        if(!productToUpdate.getImage().equals(productDetails.getImage())){
            productToUpdate.setImage(productDetails.getImage());
        }

        if(!productToUpdate.getPrice().equals(productDetails.getPrice())){
            productToUpdate.setPrice(productDetails.getPrice());
        }

        if(!productToUpdate.getIdentifier().equals(productDetails.getIdentifier())){
            productToUpdate.setIdentifier(productDetails.getIdentifier());
        }

        return saveToDb(productToUpdate);
    }

    @Override
    public List<Product> getAllProductsInCategory(ProductCategory category) throws ProductException {
        return getAllProductCategoryFromDb(category);
    }

    private List<Product> getAllProductCategoryFromDb(ProductCategory category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public List<Product> getAllProductWithNameContaining(String productName) {
       return getAllProductNameFromDb(productName);
    }

    @Override
    public Product findProductById(String productId) throws ProductException {
        return findProduct(productId);
    }

    private Product findProduct(String productId) throws ProductException {
        Optional<Product> productToFind = productRepository.findById(productId);
        if(productToFind.isPresent()){
            return productToFind.get();
        }else throw new ProductException("Product with this identifier does not exist");
    }

    private List<Product> getAllProductNameFromDb(String productName) {
        return productRepository.findAllByNameContaining(productName);
    }

    private Product saveToDb(Product product){
        return productRepository.save(product);
    }

    private Product findProductByIdentifier(String identifier) throws ProductException {
        Optional<Product> productToFind = productRepository.findProductByIdentifier(identifier);
        if(productToFind.isPresent()){
            return productToFind.get();
        }else throw new ProductException("Product with this identifier does not exist");
    }

    private void deleteAllProductFromDb() {
        productRepository.deleteAll();
    }

    private void deleteProductFromDb(String identifier) {
        productRepository.deleteByIdentifier(identifier);
    }

}

package mini.repositories;

import mini.models.Product;
import mini.models.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    void deleteByIdentifier(String identifier);
    Optional<Product> findProductByIdentifier(String identifier);
    List<Product> findAllByCategory(ProductCategory category);
    List<Product> findAllByNameContaining(String productName);
}


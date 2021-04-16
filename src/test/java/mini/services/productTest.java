package mini.services;

import lombok.extern.slf4j.Slf4j;
import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.models.Product;
import mini.models.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class productTest {
    @Autowired
    ProductService productService;

    @Test
    void AddProduct() throws ProductException {
//        FrontEnd
        ProductDTO productDTO = new ProductDTO("Lift chair", "good on road", new BigDecimal(2000), "lift-chair.png", ProductCategory.SEAT, "B1");
//        Service
        productService.addProduct(productDTO);
//        Assert
        assertEquals(productService.count(), 1);
    }

    @Test
    void canDeleteProductFromDB() throws ProductException {
//        FrontEnd
        ProductDTO productDTO = new ProductDTO("Lift bed", "good and comfortable", new BigDecimal(12300), "lift-bed.png", ProductCategory.BED, "B2");
//        Service
        productService.addProduct(productDTO);
        assertEquals(productService.count(), 2);

        productService.removeProduct(productDTO.getIdentifier());
//        Assert
        assertEquals(productService.count(), 1);
    }

    @Test
    void canDeleteAllProductFromDb() {
        productService.removeAllProduct();
        assertEquals(productService.count(), 0);
    }

    @Test
    void getAllProductsFromDb() throws ProductException {
        ProductDTO productDTO = new ProductDTO("Lift chair", "good on road", new BigDecimal(2000), "lift-chair.png", ProductCategory.SEAT, "B1");
        ProductDTO anotherDTO = new ProductDTO("Lift bed", "good and comfortable", new BigDecimal(12300), "lift-bed.png", ProductCategory.BED, "B2");

        productService.addProduct(anotherDTO);
        productService.addProduct(productDTO);

        assertEquals(productService.count(), 2);

        List<Product> productList = productService.getAllProduct();
        assertNotNull(productList);
    }

    @Test
    void canUpdateProductDetail() throws ProductException {
        ProductDTO productDTO = new ProductDTO("Laser table", "easy to set", new BigDecimal(1000), "lift-laser.png", ProductCategory.TABLES, "B1");
        Product product = productService.updateProduct("B1", productDTO);
        assertNotNull(product);
    }
}

package mini.services;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.models.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
}

package mini.controllers;

import mini.dtos.ProductDTO;
import mini.exceptions.ProductException;
import mini.models.ApiResponse;
import mini.models.Product;
import mini.models.ProductCategory;
import mini.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products/new")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDto) throws ProductException {
        productService.addProduct(productDto);
        return new ResponseEntity<>(new ApiResponse(true, "Product created successfully"), HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> removeProduct(@PathVariable String productId) throws ProductException {
        productService.removeProduct(productId);
        return new ResponseEntity<>(new ApiResponse(true, "product removed successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/products")
    public ResponseEntity<?> deleteAllProduct(){
        productService.removeAllProduct();
        return new ResponseEntity<>(new ApiResponse(true, "All product removed successfully"), HttpStatus.OK);
    }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO updatedProductDetails, @PathVariable String productId) throws ProductException {
        productService.updateProduct(productId, updatedProductDetails);
        return new ResponseEntity<>(new ApiResponse(true, "product updated successfully"), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId) throws ProductException {
        Product product = productService.findProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products/category/{productCategory}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable ProductCategory productCategory) throws ProductException {
        List<Product> products = productService.getAllProductsInCategory(productCategory);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

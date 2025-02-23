package dev.amrish.productservice.controllers;


import dev.amrish.productservice.dtos.CreateProductRequestDto;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping("/create")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        return productService.createProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getImage(),
                createProductRequestDto.getCategory(),
                createProductRequestDto.getPrice()
        );
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
       return productService.getProductById(id);
    }

    @GetMapping("/all")
    public  ResponseEntity <List<Product>> getAllProducts() {

        List<Product> response = productService.getAllProducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(response, HttpStatusCode.valueOf(202));

        return responseEntity;

    }


    public void updateProduct() {

    }

    public void deleteProduct() {

    }
}

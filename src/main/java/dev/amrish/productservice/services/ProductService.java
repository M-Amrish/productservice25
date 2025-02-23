package dev.amrish.productservice.services;

import dev.amrish.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long id);

    public Product createProduct(String title, String description,
                                 String image, String category, double price);

    public List<Product> getAllProducts();
}

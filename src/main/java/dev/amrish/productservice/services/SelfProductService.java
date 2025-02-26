package dev.amrish.productservice.services;


import dev.amrish.productservice.models.Category;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.respositories.CategoryRepository;
import dev.amrish.productservice.respositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;


    SelfProductService(CategoryRepository categoryRepository,
                       ProductRepository productRepository ){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findByIdIs(id);
    }

    @Override
    public Product createProduct(String title, String description, String image, String categoryTitle, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);

        Category categoryFromDatabase  = categoryRepository.findByTitle(categoryTitle);
        if(categoryFromDatabase  == null){
            Category category = new Category();
            category.setTitle(categoryTitle);
            categoryFromDatabase  = category;
            // categoryRepository.save(category);
        }
        // If category was found from DB, then no new category will be created
        // If category is not found in the DB, a new category will be created because of cascade persist type
        product.setCategory(categoryFromDatabase);

        List<Product> productsTemp = categoryFromDatabase.getProducts();

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

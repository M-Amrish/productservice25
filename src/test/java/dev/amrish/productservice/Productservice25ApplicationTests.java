package dev.amrish.productservice;

import dev.amrish.productservice.models.Category;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.respositories.CategoryRepository;
import dev.amrish.productservice.respositories.ProductRepository;
import dev.amrish.productservice.respositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Productservice25ApplicationTests {

//    @Autowired // -- Tells spring to inject the object of prod repo
//    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testQuery() {
//        Product product = productRepository.getProductWithSpecificTitleAndId("LG Tv",1L);
//        System.out.println(product.getTitle());
//    }
//
//    @Test
//    void testQuery1(){
//        Product product = productRepository.getProductWithSomeTitleAndId("Iphone", 52L);
//        System.out.println(product.getDescription());
//    }
//
//    @Test
//    void testQuery2(){
//        ProductWithIdAndTitle product= productRepository.getProductWithSpecificTitleAndId2("Washing Machine",2L);
//
//        System.out.println(product.getId());
//        System.out.println(product.getTitle());
//     //   System.out.println(product.getDescription());
//    }
//
//    @Test
//    @Transactional
//    public void testingFetchTypes() {
//        Category category = categoryRepository.findByTitle("Electonics");
//        System.out.println(category.getProducts());
//    }
//
//    @Test
//    public void testingFetchTypes2() {
//        Category category = categoryRepository.findByTitle("Electonics");
//        System.out.println(category.getTitle());
//    }
//
//    @Test
//    public void testingFetchTypes3() {
//        Optional<Category> category = categoryRepository.findById(1L);
//        System.out.println(category.get().getTitle());
// }
//
//    @Test
//    @Transactional
//    public void nplus1problem() {
//        // Get all cats and for each cat get the product and
//        // print title of each product
//        List<Category> categories = categoryRepository.findAll();
//        for(Category category: categories) {
//            for(Product product: category.getProducts()) {
//                System.out.println(product.getTitle());
//            }
//        }
//
//    }
}

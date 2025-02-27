package dev.amrish.productservice.respositories;

import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.respositories.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdIs(Long id);

    List<Product> findAll();

    // HQL Hibernate Query language
    @Query("select p from Product p where p.title = :title and p.id = :id")
    Product getProductWithSpecificTitleAndId(@Param("title") String title, @Param("id") Long id);

    // Native SQL query
    @Query(value = "select * from Product p where p.title =  :title AND P.id = :id ",nativeQuery = true)
    Product getProductWithSomeTitleAndId(@Param("title") String title, @Param("id") Long id);

    @Query("select p.id, p.title from Product p where p.title = :title and p.id = :id")
    ProductWithIdAndTitle getProductWithSpecificTitleAndId2(@Param("title") String title, @Param("id") Long id);

    Page<Product> findByTitleContaining(String title, Pageable pageable);
}

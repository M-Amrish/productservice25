package dev.amrish.productservice.respositories;

import dev.amrish.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdIs(Long id);

    List<Product> findAll();
}

package dev.amrish.productservice.services;

import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.respositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private ProductRepository productRepository;

    SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int page, int size) {

        Sort sort = Sort.by("title").descending()
                .and(Sort.by("price").ascending());

        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findByTitleContaining(query,pageable);

    }
}

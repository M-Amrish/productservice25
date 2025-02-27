package dev.amrish.productservice.controllers;

import dev.amrish.productservice.dtos.SearchDTO;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private SearchService searchService;

    SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> searchProduct(@RequestBody SearchDTO searchDTO) {
          return  searchService.search(
                    searchDTO.getTitle(),
                    searchDTO.getPage(),
                    searchDTO.getSize()
            );
    }
}

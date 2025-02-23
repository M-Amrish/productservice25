package dev.amrish.productservice.services;

import dev.amrish.productservice.dtos.FakeStoreProductDto;
import dev.amrish.productservice.models.Category;
import dev.amrish.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;

//        FakeStoreProductDto fakeStoreProductDto =
//        restTemplate
//                .getForObject(
//                    url,
//                    FakeStoreProductDto.class
//                );

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(
                        url,
                        FakeStoreProductDto.class
                );
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        return toProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        String url = "https://fakestoreapi.com/products";

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);

        FakeStoreProductDto response =
                restTemplate.postForObject(
                        url,
                        fakeStoreProductDto,
                        FakeStoreProductDto.class
                );

        return toProduct(response);
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";

        FakeStoreProductDto[] response =
                restTemplate.getForObject(
                    url,
                    FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : response){
                products.add(toProduct(fakeStoreProductDto));
        }

        return products;
    }


    private Product toProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}

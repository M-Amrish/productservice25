package dev.amrish.productservice.dtos;

import lombok.*;

// Contains getters and setters and toString method as well as equals and hashCode methods
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

}

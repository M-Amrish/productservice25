package dev.amrish.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchDTO {
    private String title;
    private int page;
    private int size;
}

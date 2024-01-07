package com.apidemo.productservice.dtos;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    @Generated
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}

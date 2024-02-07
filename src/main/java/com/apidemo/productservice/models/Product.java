package com.apidemo.productservice.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    @Column(length = 700)
    private String description;
    private String image;
    private int numberOfSales;
}

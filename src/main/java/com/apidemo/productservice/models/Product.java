package com.apidemo.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private Long id;
    private String title;
    private Double price;
    @ManyToOne
    private Category category;
    @Column(length = 700)
    private String description;
    private String image;
    private int numberOfSales;
}

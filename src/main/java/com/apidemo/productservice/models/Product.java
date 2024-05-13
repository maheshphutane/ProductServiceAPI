package com.apidemo.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Product extends BaseModel implements Serializable {
    private String title;
    private Double price;
    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private Category category;
    @Column(length = 700)
    private String description;
    private String image;
    private int numberOfSales;
}

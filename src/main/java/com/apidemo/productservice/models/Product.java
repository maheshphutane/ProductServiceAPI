package com.apidemo.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Document(indexName = "product")
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

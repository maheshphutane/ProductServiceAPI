package com.apidemo.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    @OneToMany(mappedBy = "category" , cascade = CascadeType.REMOVE)
    // being already mapped by an attribute called category
    private List<Product> productList;
    private String name;
    private String description;
    private String imageUrl;
    public Category(String name){
        this.name = name;
    }
}

package com.apidemo.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @OneToMany(mappedBy = "category" , cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    // being already mapped by an attribute called category
    private List<Product> productList;
    private String name;
    private String description;
    private String imageUrl;
}

//CascadeType.REMOVE : Will remove all the products of the respective which is removed
//fetch = FetchType.EAGER : Will Load all the attributes of the class by performing join
//fetch = FetchType.LAZY : Will load only primitive attributes of the class not any collections
// (This is by default fetch type in JPA for collection attribute)

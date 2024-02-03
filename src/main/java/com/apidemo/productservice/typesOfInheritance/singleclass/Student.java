package com.apidemo.productservice.typesOfInheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {
    private String BatchId;
}

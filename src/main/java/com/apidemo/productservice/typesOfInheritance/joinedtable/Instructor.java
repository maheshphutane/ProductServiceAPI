package com.apidemo.productservice.typesOfInheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_instructor")
@Getter
@Setter
@PrimaryKeyJoinColumn()
public class Instructor extends User {
    private double avgRating;
}



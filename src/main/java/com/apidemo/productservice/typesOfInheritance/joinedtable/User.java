package com.apidemo.productservice.typesOfInheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}

// Joined Table create table for each class and also
// add the primary key of supper class to the child class as a foreign key
// So that after join we can retrieve details of respective user id
// present in child classes
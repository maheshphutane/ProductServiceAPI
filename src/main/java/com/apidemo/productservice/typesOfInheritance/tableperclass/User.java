package com.apidemo.productservice.typesOfInheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}

//TABLE_PER_CLASS works similar as MappedSupperClass in addition,
// it will create table for superclass
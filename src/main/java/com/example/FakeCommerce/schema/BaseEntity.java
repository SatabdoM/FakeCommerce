package com.example.FakeCommerce.schema;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
//We do not want a table of base entity
//We want to use the id field in the base entity for all the entities that extend it
// MappedSuperclass: This annotation indicates that the class is a base class for other entities, and its properties will be inherited by the subclasses.
// It does not create a separate table for the base class in the database

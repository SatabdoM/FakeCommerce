package com.example.FakeCommerce.schema;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
//We do not want a table of base entity
//We want to use the id field in the base entity for all the entities that extend it
// MappedSuperclass: This annotation indicates that the class is a base class for other entities, and its properties will be inherited by the subclasses.
// It does not create a separate table for the base class in the database.
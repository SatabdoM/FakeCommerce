package com.example.FakeCommerce.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal price;

    private String image;

    private String category;

    private String rating;

}

// The strategy comes from Strategy pattern
// IDENTITY: Auto-incrementing field in the database. For Primary Keys


// Category itself is an entity
// Sale on category
// Relationship:
// OneToMany: One category can have many products


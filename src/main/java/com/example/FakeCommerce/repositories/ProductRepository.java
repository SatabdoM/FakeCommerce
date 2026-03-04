package com.example.FakeCommerce.repositories;

import com.example.FakeCommerce.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(String category);

    @Query("SELECT DISTINCT p.category FROM Product p")
    public List<String> findAllCategories();

    @Query(nativeQuery = true,
            value = "SELECT p.*, c.* FROM product p INNER JOIN category c ON p.category_id = c.id WHERE p.id = :id")
    List<Product> findProductWithDetailsById(Long id);

}
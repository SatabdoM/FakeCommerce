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

//    @Query(nativeQuery = true,
//            value = "SELECT p.* ,c.name as categoryName  FROM products p INNER JOIN categories c ON p.category = c.id WHERE p.id = :id")
    // For raw queries, JPA will not have context of the category name and will not be able to map it to the product object.
    // Hence we can use Hybernate FETCH JOIN to fetch the category name along with the product details in a single query and map it to the product object.
    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.id = :id")
    public List<Product> findProductWithDetailsById(Long id);

}
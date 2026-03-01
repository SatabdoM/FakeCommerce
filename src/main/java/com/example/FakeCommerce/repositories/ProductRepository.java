package com.example.FakeCommerce.repositories;

import com.example.FakeCommerce.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
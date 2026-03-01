package com.example.FakeCommerce.controllers;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.schema.Product;
import com.example.FakeCommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto) {
        System.out.println("Here");
        return productService.createProduct(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    //Using PathVariable
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // Using RequestParam
    @GetMapping("/search")
    public List<Product> searchProductsByCategory(@RequestParam("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }


}

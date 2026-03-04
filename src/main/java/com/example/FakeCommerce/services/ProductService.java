package com.example.FakeCommerce.services;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.dtos.GetProductResponseDto;
import com.example.FakeCommerce.dtos.GetProductWithDetailsResponseDto;
import com.example.FakeCommerce.repositories.CategoryRepository;
import com.example.FakeCommerce.repositories.ProductRepository;
import com.example.FakeCommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // n+1 problem: When we get all products, we also want to get the category name for each product.
    // Will get all products and for all unique categories, it will fire a query to get the category name and set it in the product object.
    // This is not efficient and can be optimized by using a join query in the repository layer.
    public List<GetProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> GetProductResponseDto.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .rating(product.getRating())
                .build()).collect(toList());
    }

    public List<GetProductWithDetailsResponseDto> getProductsWithDetailsById(Long id) {
        return productRepository.findProductWithDetailsById(id).stream().map(product ->
                GetProductWithDetailsResponseDto.builder()
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .rating(product.getRating())
                        .categoryName(product.getCategory().getName())
                        .build()).collect(toList());
    }

    public Product createProduct(CreateProductRequestDto requestDto) {
        System.out.println("debug!");
        System.out.println(requestDto.getCategoryId());
        System.out.println(categoryRepository.findById(requestDto.getCategoryId()));

        Product newProdict = Product.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .image(requestDto.getImage())
                .category(categoryService.getCategoryById(requestDto.getCategoryId()))
                .rating(requestDto.getRating())
                .build();
        return productRepository.save(newProdict);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }

}

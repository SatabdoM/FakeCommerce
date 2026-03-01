package com.example.FakeCommerce.services;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.repositories.ProductRepository;
import com.example.FakeCommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(CreateProductRequestDto requestDto) {
        Product newProdict = Product.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .image(requestDto.getImage())
                .category(requestDto.getCategory())
                .rating(requestDto.getRating())
                .build();
        return productRepository.save(newProdict);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}

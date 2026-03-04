package com.example.FakeCommerce.controllers;


import com.example.FakeCommerce.dtos.CreateCategoryRequestDto;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(@RequestParam("name") String name) {
        System.out.println("Creating category: " + name);
        return categoryService.createCategory(new CreateCategoryRequestDto(name));
    }

    @GetMapping
    public String getAllCategories() {
        return categoryService.getAllCategories().toString();
    }
}

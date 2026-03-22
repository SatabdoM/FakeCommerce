package com.example.FakeCommerce.controllers;


import com.example.FakeCommerce.dtos.CreateCategoryRequestDto;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestParam("name") String name) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(new CreateCategoryRequestDto(name)));
    }

    @GetMapping
    public String getAllCategories() {
        return categoryService.getAllCategories().toString();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        //System.out.println("debug! deleting category with id: " + id);
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

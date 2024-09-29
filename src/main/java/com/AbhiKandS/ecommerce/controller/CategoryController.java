package com.AbhiKandS.ecommerce.controller;

import com.AbhiKandS.ecommerce.Category;
import com.AbhiKandS.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> response = categoryService.getCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/admin/categories")
    public String pushBackCategories(@RequestBody List<Category> newCategories) {
        return categoryService.pushBackCategories(newCategories);
    }

    @PostMapping("/admin/category")
    public ResponseEntity<String> pushBackCategory(@RequestBody String categoryName) {
        String response = categoryService.pushBackCategory(categoryName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryID}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryID) {
        try {
            String status = categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/categories/{categoryID}")
    public ResponseEntity<String> updateCategory(@PathVariable long categoryID, @RequestBody String categoryName) {
        try {
            String status = categoryService.updateCategory(categoryID, categoryName);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}

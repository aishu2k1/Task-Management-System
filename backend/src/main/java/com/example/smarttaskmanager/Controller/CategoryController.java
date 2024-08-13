package com.example.smarttaskmanager.Controller;

import com.example.smarttaskmanager.Model.Category;
import com.example.smarttaskmanager.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/users/{userName}/categories")
    public ResponseEntity<List<Category>> getAllCategories(@PathVariable String userName) {
        List<Category> categories = categoryService.getCategories(userName);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/users/{userName}/category/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable String userName, @PathVariable Long id){
        Category category = categoryService.findCategoryById(userName, id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/users/{userName}/createCategory")
    public ResponseEntity<Category> createCategory(@PathVariable String userName, @RequestBody Category categoryNew){
        Category category = categoryService.createCategory(userName, categoryNew);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/users/{userName}/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String userName, @PathVariable Long id, @RequestBody Category categoryNew){
        Category category = categoryService.updateCategory(userName, id, categoryNew);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/users/{userName}/deleteCategory/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String userName, @PathVariable Long id){
        boolean deleted = categoryService.deleteCategory(id, userName);
        if (deleted){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}

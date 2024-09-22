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

    @GetMapping("/users/{user_name}/categories")
    public ResponseEntity<List<Category>> getAllCategories(@PathVariable String user_name) {
        List<Category> categories = categoryService.getCategories(user_name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/users/{user_name}/category/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable String user_name, @PathVariable Long id){
        Category category = categoryService.findCategoryById(user_name, id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/users/{user_name}/category")
    public ResponseEntity<Category> createCategory(@PathVariable String user_name, @RequestBody Category categoryNew){
        Category category = categoryService.createCategory(user_name, categoryNew);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/users/{user_name}/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String user_name, @PathVariable Long id, @RequestBody Category categoryNew){
        Category category = categoryService.updateCategory(user_name, id, categoryNew);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/users/{user_name}/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String user_name, @PathVariable Long id){
        boolean deleted = categoryService.deleteCategory(id, user_name);
        if (deleted){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}

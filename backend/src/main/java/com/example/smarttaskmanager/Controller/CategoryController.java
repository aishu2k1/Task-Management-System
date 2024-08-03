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

    @GetMapping("/categories/{userName}")
    public ResponseEntity<List<Category>> getAllCategories(@PathVariable String userName) {
        List<Category> categories = categoryService.getCategories(userName);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category categoryNew){
        Category category = categoryService.createCategory(categoryNew);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category categoryNew){
        Category category = categoryService.updateCategory(categoryNew);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/deleteCategory/{id}/{userName}")
    public ResponseEntity<Void> deleteCategory(@RequestBody Long id, @RequestBody String userName){
        boolean deleted = categoryService.deleteCategory(id, userName);
        if (deleted){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}

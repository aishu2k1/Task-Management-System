package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Category;
import com.example.smarttaskmanager.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(String userName){
        return categoryRepository.findByUsername(userName);
    }

    public Category findCategoryById(String userName, Long id){
        return categoryRepository.findById(id).map(category -> {
            if(category.getUserName().equals(userName)){
                return category;
            }
            return null;
        }
        ).orElse(null);
    }

    public Category createCategory(String userName, Category categoryNew){
        categoryNew.setUserName(userName);
        return categoryRepository.save(categoryNew);
    }

    public Category updateCategory(String userName, Long id, Category categoryNew){
        categoryNew.setUserName(userName);
        categoryNew.setId(id);
        return categoryRepository.findById(id).map(category -> {
            if(category.getUserName().equals(userName)){
                category.setName(categoryNew.getName());
                return categoryRepository.save(category);
            }
            return categoryRepository.save(category);
        }).orElse(categoryRepository.save(categoryNew));
    }

    public boolean deleteCategory(Long id, String userName){
        return categoryRepository.findById(id).map(category -> {
            if (category.getUserName().equals(userName)){
                categoryRepository.deleteById(id);
                return true;}
            return false;
        }).orElse(false);
    }
}

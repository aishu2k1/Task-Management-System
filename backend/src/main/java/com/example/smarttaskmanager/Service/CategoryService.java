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
        return categoryRepository.findByUserOrNoUser(userName);
    }

    public Category findCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public Category createCategory(Category categoryNew){
        return categoryRepository.save(categoryNew);
    }

    public Category updateCategory(Category categoryNew){
        return categoryRepository.findById(categoryNew.getId()).map(category -> {
            if(category.getUserName().equals(categoryNew.getUserName())){
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

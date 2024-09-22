package com.example.smarttaskmanager.Service;

import com.example.smarttaskmanager.Model.Category;
import com.example.smarttaskmanager.Model.User;
import com.example.smarttaskmanager.Repository.CategoryRepository;
import com.example.smarttaskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Category> getCategories(String userName){
        return Stream.concat(categoryRepository.findByUser_UserName(userName).stream(), categoryRepository.findByUserIsNull().stream()).toList();
    }

    public Category findCategoryById(String userName, Long id){
        return categoryRepository.findById(id).map(category -> {
            if(category.getUser() == null || category.getUser().getUserName().equals(userName)){
                return category;
            }
            return null;
        }).orElse(null);
    }

    public Category createCategory(String userName, Category categoryNew){
        User user = new User();
        user.setUserName(userName);
        categoryNew.setUser(user);
        return categoryRepository.save(categoryNew);
    }

    public Category updateCategory(String userName, Long id, Category categoryNew){
        return categoryRepository.findById(id).map(category -> {
            if(category.getUser().getUserName().equals(userName)){
                category.setName(categoryNew.getName());
                return categoryRepository.save(category);
            }
            return null;
        }).orElse(null);
    }

    public boolean deleteCategory(Long id, String userName){
        return categoryRepository.findById(id).map(category -> {
            if (category.getUser().getUserName().equals(userName)){
                categoryRepository.deleteById(id);
                return true;}
            return false;
        }).orElse(false);
    }
}

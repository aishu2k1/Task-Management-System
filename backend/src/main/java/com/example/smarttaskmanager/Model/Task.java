package com.example.smarttaskmanager.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    //foreign key to category
    @OneToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Long categoryId;

    //foreign key to user
    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User user;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;
    
    private String title;
    private String description;

    
    public Course() {}


    public Course(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}

package com.springrest.springrest.entities;

public class Course {
    private long id;
    private String title; 
    private String description;

    public Course(long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setDescription(String description) { // Fixed typo
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {  
        return id;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
}

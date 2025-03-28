package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.springrest.springrest.entities.CourseResponse;






@RestController
public class MyController {

   
    // private final CourseService courseservice;

    // public MyController(CourseService courseservice) {
    //     this.courseservice = courseservice;
    // }

    @Autowired
    private CourseService courseservice;
    
    @GetMapping("/home")
    public String home() {
        return "Welcome to course application ";
    }
    
    //get the courses
    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getCourses() {
        try {
            List<CourseResponse> courses = this.courseservice.getCourses();
            
            if (courses.isEmpty()) { 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
            }
            
            return new ResponseEntity<>(courses, HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }
    

    //get course by Id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseservice.getCourse(Long.parseLong(courseId));
    }

    //add course
    @PostMapping(path = "/courses", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        try {
            System.out.println("Received Course: " + course); 
            Course savedCourse = courseservice.addCourse(course);
            return new ResponseEntity<>(savedCourse, HttpStatus.CREATED); //201
        } catch (Exception e) {
            e.printStackTrace(); // Log error details
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //500
        }   
    }
    
    
    //update the course
    @PutMapping("/courses")
    public Course updateCourse( @RequestBody Course course) {
        return this.courseservice.updateCourse(course);
    }
   
    
     //delete the course
    @DeleteMapping("/courses/{courseId}")
public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
    try {
        this.courseservice.deleteCourse(Long.parseLong(courseId));
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}
    
}   

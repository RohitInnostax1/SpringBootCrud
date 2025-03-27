package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






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
    public List<Course> getCourses()
    {
        return this.courseservice.getCourses();
    }

    //get course by Id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseservice.getCourse(Long.parseLong(courseId));
    }

    //add course 
    @PostMapping(path="/courses",consumes="application/json")
    public Course addCourse(@RequestBody Course course) {
        return this.courseservice.addCourse(course);

    }

    //update the course
    @PutMapping("/courses")
    public Course updateCourse( @RequestBody Course course) {
        return this.courseservice.updateCourse(course);
    }
   
    
    // //delete the course
    @DeleteMapping("/courses/{courseId}")
public Course deleteCourse(@PathVariable String courseId) {
    return this.courseservice.deleteCourse(Long.parseLong(courseId));
}
    
}   

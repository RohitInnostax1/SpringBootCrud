package com.springrest.springrest.services;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImplement implements CourseService {

    @Autowired
    private CourseDao courseDao;

    // private List<Course> list;

    
    // public CourseServiceImplement() {
    //     // list = new ArrayList<>();
    //     // list.add(new Course(145L, "Java Course", "This course covers core concept of Java."));
    //     // list.add(new Course(2222L, "Web Dev", "This course covers MERN Stack Topics."));
    // }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
      
        return courseDao.findById(courseId).orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public void deleteCourse(long courseId) {
       
        Optional<Course> entity = courseDao.findById(courseId);
        entity.ifPresent(courseDao::delete);
    }
}

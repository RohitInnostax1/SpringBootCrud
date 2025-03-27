package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImplement implements CourseService {
    private List<Course> list;

    public CourseServiceImplement() {
        list = new ArrayList<>();
        list.add(new Course(145, "Javaa Course", "This course covers core concept of Java."));
        list.add(new Course(2222, "Web Dev", "This course covers MERN Stack Topics."));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId)
    {
        Course c=null;
        for(Course course:list){
            if(course.getId()==courseId)
            {
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course)
    {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course)
    {
     list.forEach(e->{
        if(e.getId()==course.getId()){
            e.setTitle(course.getTitle());
            e.setDescription(course.getDescription());
        }
     });
     return course;
    }

    @Override
    public Course deleteCourse(long courseId) {
        Course deletedCourse = null;
        
        for (Course course : list) {
            if (course.getId() == courseId) {
                deletedCourse = course;
                break;
            }
        }
        
        if (deletedCourse != null) {
            list = list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());
        }
    
        return deletedCourse; 
    }
    
}

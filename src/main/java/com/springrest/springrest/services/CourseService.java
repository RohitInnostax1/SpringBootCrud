package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.CourseResponse;

public interface  CourseService {
    public List<CourseResponse> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(long couseId);
}

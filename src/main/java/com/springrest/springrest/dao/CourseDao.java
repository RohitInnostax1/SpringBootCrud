// package com.springrest.springrest.dao;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.springrest.springrest.entities.Course;

// @Repository
// public interface CourseDao extends JpaRepository<Course, Long> {
    
// }
package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;
import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();   
    Course getCourseById(Long id);  
    Course saveCourse(Course course); 
    Course updateCourse(Course course); 
    void deleteCourse(Long id);  
}

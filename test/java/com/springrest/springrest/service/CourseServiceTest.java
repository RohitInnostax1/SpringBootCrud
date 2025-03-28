package com.springrest.springrest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServiceImplement;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {
    
    @Mock
    CourseDao courseDao;  
    
    @InjectMocks
    CourseServiceImplement courseService;  

    @Test
    void addCourseShouldAddCourseSuccessfully() {
       
        Course course = new Course(1L, "Java Course", "Learn Java");


        when(courseDao.saveCourse(course)).thenReturn(course);

       
        Course savedCourse = courseService.addCourse(course);

      
        assertNotNull(savedCourse);  
        assertEquals(1L, savedCourse.getId()); 
        assertEquals("Java Course", savedCourse.getTitle());  
        assertEquals("Learn Java", savedCourse.getDescription());  

      
        verify(courseDao, times(1)).saveCourse(course); 

       
        System.out.println("Test successfully completed");
    }
}

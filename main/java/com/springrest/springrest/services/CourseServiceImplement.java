// package com.springrest.springrest.services;

// import java.util.ArrayList;
// // import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.springrest.springrest.dao.CourseDao;
// import com.springrest.springrest.entities.Course;
// import com.springrest.springrest.entities.CourseResponse;

// @Service
// public class CourseServiceImplement implements CourseService {

//     @Autowired
//     private CourseDao courseDao;

//     // private List<Course> list;

    
//     // public CourseServiceImplement() {
//     //     // list = new ArrayList<>();
//     //     // list.add(new Course(145L, "Java Course", "This course covers core concept of Java."));
//     //     // list.add(new Course(2222L, "Web Dev", "This course covers MERN Stack Topics."));
//     // }

//     @Override
//     public List<CourseResponse> getCourses() {
//         List<CourseResponse> courseResponse=new ArrayList<>();
//         List<Course> courses=courseDao.findAll();
//         for(Course course:courses)
//         {
//             CourseResponse response=new CourseResponse();
//             response.setId(course.getId());
//             response.setTitle(course.getTitle());
//             courseResponse.add(response);
//         }
//         return courseResponse;
//     }

//     @Override
//     public Course getCourse(long courseId) {
      
//         return courseDao.findById(courseId).orElse(null);
//     }

//     @Override
//     public Course addCourse(Course course) {
//         return courseDao.save(course);
//     }

//     @Override
//     public Course updateCourse(Course course) {
//         return courseDao.save(course);
//     }

//     @Override
//     public void deleteCourse(long courseId) {
       
//         Optional<Course> entity = courseDao.findById(courseId);
//         entity.ifPresent(courseDao::delete);
//     }
// }

package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServiceImplement implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CourseResponse> getCourses() {
        List<CourseResponse> courseResponse = new ArrayList<>();
        List<Course> courses = courseDao.getAllCourses();
        for (Course course : courses) {
            CourseResponse response = new CourseResponse();
            response.setId(course.getId());
            response.setTitle(course.getTitle());
            courseResponse.add(response);
        }
        return courseResponse;
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourse(long courseId) {
        courseDao.deleteCourse(courseId);
    }
}



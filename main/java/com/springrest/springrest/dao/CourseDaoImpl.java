package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course saveCourse(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}

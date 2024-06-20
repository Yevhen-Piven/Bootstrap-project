package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}

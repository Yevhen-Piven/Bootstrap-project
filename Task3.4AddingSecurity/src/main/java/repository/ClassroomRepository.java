package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

}

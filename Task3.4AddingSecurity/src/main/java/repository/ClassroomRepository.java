package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

}

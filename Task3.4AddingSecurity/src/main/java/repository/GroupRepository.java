package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}

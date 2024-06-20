package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}

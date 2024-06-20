package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}

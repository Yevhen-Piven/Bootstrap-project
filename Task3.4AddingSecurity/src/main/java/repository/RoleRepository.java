package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}

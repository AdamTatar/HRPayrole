package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

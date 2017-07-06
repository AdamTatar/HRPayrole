package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}

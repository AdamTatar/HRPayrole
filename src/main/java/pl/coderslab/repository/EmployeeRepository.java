package pl.coderslab.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findBySalaryNotNull();
	public List<Employee> findAllByLastNameLike(String lastName);
	public List<Employee> findAllByPeselLike(String pesel);
	public List<Employee> findAllBySalaryGreaterThan(BigDecimal salary);
	
	
}

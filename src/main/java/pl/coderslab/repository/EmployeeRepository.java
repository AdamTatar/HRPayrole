package pl.coderslab.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.City;
import pl.coderslab.model.Department;
import pl.coderslab.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findBySalaryNotNull();
	public List<Employee> findAllByLastNameLike(String lastName);
	public List<Employee> findAllByFirstNameLike(String lastName);
	public List<Employee> findAllByPeselLike(String pesel);
	public List<Employee> findAllBySalaryGreaterThan(BigDecimal salary);
	public List<Employee> findAllByBonusGreaterThan(BigDecimal bonus);
	public List<Employee> findAllByCity(City city);
	public List<Employee> findAllByDepartment(Department department);
	public List<Employee> findAllByFirstNameLikeAndLastNameLikeAndPeselLike(String firstName, String lastName, String pesel);
	public List<Employee> findAllByFirstNameStartingWithAndLastNameStartingWithAndPeselStartingWith(String firstName, String lastName, String pesel);
	public List<Employee> findAllByPeselStartingWith(String pesel);
	public List<Employee> findAllByFirstNameStartingWithAndLastNameStartingWith(String firstName, String lastName);
	public List<Employee> findAllByDateOfEmploymentAfter(Date date);
	
	
	
	
}

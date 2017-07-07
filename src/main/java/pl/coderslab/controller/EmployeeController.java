package pl.coderslab.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.City;
import pl.coderslab.model.Country;
import pl.coderslab.model.Department;
import pl.coderslab.model.Employee;
import pl.coderslab.model.TaxOffice;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.CountryRepository;
import pl.coderslab.repository.DepartmentRepository;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.TaxOfficeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private TaxOfficeRepository taxOfficeRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@ModelAttribute("countries")
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@ModelAttribute("taxOffices")
	public List<TaxOffice> getAllTaxOffices() {
		return taxOfficeRepository.findAll();
	}

	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@ModelAttribute("departments")
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employeeAdd";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addEmployeePost(@Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employeeAdd";
		}
		employeeRepository.save(employee);
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	// edycja pracownika:

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(Model model, @PathVariable Long id) {
		Employee employee = null;
		employee = employeeRepository.findOne(id);
		if (employee == null) {
			return "redirect:/HRPayrole/employee";
		}
		model.addAttribute("employee", employee);
		return "employeeEdit";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String editEmployeeMethodPost(@Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employeeEdit";
		}

		employeeRepository.save(employee);
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	// detailed info about employee:
	@RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
	public String detailedEmployeeInfo(Model model, @PathVariable Long id) {
		Employee employee = null;
		employee = employeeRepository.findOne(id);
		if (employee == null) {
			return "redirect:/employee";
		}
		model.addAttribute("employee", employee);
		return "employeeDetails";
	}

	// search:

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String showEmployeeSearchForm(Model model) {
		Employee employee = new Employee();
		employee.setSalary(new BigDecimal("0"));
		employee.setBonus(new BigDecimal("0"));
		model.addAttribute("employee", employee);
		return "employeeSearch";
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String employeeSearch(Employee employee, Model model) {

		List<Employee> employees = null;
		if(employee.getDateOfEmployment() != null){
			employees = employeeRepository.findAllByDateOfEmploymentAfter(employee.getDateOfEmployment());
			model.addAttribute("employees", employees);
			return "employeeList";
		}
		if (employee.getSalary().signum() > 0){
			employees = employeeRepository.findAllBySalaryGreaterThan(employee.getSalary());
			model.addAttribute("employees", employees);
			return "employeeList";
		}
		if (employee.getBonus().signum() > 0){
			employees = employeeRepository.findAllByBonusGreaterThan(employee.getBonus());
			model.addAttribute("employees", employees);
			return "employeeList";
		}
		
		employees = employeeRepository.findAllByFirstNameStartingWithAndLastNameStartingWithAndPeselStartingWith(employee.getFirstName(), employee.getLastName(), employee.getPesel());
		model.addAttribute("employees", employees);
		return "employeeList";
	}

}
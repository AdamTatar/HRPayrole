package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.City;
import pl.coderslab.model.Country;
import pl.coderslab.model.Department;
import pl.coderslab.model.Employee;
import pl.coderslab.model.EmployeeDetails;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.CountryRepository;
import pl.coderslab.repository.DepartmentRepository;
import pl.coderslab.repository.EmployeeDetailsRepository;
import pl.coderslab.repository.EmployeeRepository;

@Controller
@RequestMapping("/employeeDetails")
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
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

	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@ModelAttribute("departments")
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addEmployeeDetails(Employee employee, Model model) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		model.addAttribute("employeeDetails", employeeDetails);
		return "employeeDetailsAdd";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addEmployeePost(@Valid EmployeeDetails employeeDetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employeeDetailsAdd";
		}
		employeeDetailsRepository.save(employeeDetails);
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}
	
	
}

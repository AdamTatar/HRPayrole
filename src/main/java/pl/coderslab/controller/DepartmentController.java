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
import pl.coderslab.model.Department;
import pl.coderslab.repository.CityRepository;
import pl.coderslab.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@ModelAttribute("cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addDepartment(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "departmentAdd";
	}
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addDepartmentPost(@Valid Department department, BindingResult result, Model model) {
		if(result.hasErrors()){
			return "departmentAdd";
		}
		departmentRepository.save(department);
		List<Department> departments = departmentRepository.findAll();
		model.addAttribute("departments", departments);
		return "departmentList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<Department> departments = departmentRepository.findAll();
		model.addAttribute("departments", departments);
		return "departmentList";
	}
}
	


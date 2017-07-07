package pl.coderslab.controller;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Employee;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.utils.ExportPayrollToXml;

@Controller
@RequestMapping("/payroll")
public class PayrollController {

	private final static String fileName = "../../Pulpit/listaPlac.xml";
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPayrollForm(Model model) {
		List<Employee> employees = employeeRepository.findBySalaryNotNull();
		for(int i = 0; i< employees.size();i++){
			Employee employee = employees.get(i);
			BigDecimal salary = employee.getSalary();
			BigDecimal bonus = employee.getBonus();
			if(bonus==null){
				continue;
			}
			employee.setSalary(salary.add(bonus));
			employee.setBonus(new  BigDecimal("0.0"));
			employees.set(i, employee);
		}
		String xml = ExportPayrollToXml.exportPayrollToXml(employees);
		try {
			Files.write(Paths.get(fileName), xml.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("employees", employees);
		return "payrollForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String exportToXml(Model model) {
	
		
		return "payrollExportSuccess";
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
//		employeeDetailsRepository.save(employee.getEmployeeDetails());
		employeeRepository.save(employee);
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	





}

package pl.coderslab.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Employee;
import pl.coderslab.model.User;
import pl.coderslab.repository.EmployeeRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/")
public class AppController {

	private final static String fileName = "../../Pulpit/Zaświadczenie o zatrudnieniu.txt";
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	// generowanie zaświadczenia o zatrudnieniu
	
	@RequestMapping(path = "/generateCertificate", method = RequestMethod.GET)
	public String showGenerateForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "generateCertyficate";
	}
	
	@RequestMapping(path = "/generateCertificate/{id}", method = RequestMethod.GET)
	public String generateCertificate(Model model, @PathVariable Long id) {
		
		Employee employee = employeeRepository.findOne(id);
		String months[] = {"stycznia", "lutego", "marca", "kwietnia", "maja", "czerwca", "lipca", "sierpnia", "września", 
		         "października", "listopada", "grudnia"};
		      
	      GregorianCalendar gcalendar = new GregorianCalendar();
	      String today = gcalendar.get(Calendar.DATE) + " " + months[gcalendar.get(Calendar.MONTH)] +" "+ gcalendar.get(Calendar.YEAR);
		      
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\t\t\t\t\t\t\t\t\tWarszawa, ");
		sb.append(today);
		sb.append("\n\n\n\n\t\t\t\tZaświadczenie o zatrudnieniu\n\n\n\n\n");
		sb.append("\tPracownik "+employee.getFirstName()+" "+employee.getLastName()+" posiadający numer PESEL "+employee.getPesel());
		sb.append(" jest zatrudniony od dnia ");
		String dateOfEmpl = employee.getDateOfEmployment().toString().substring(0, 10);
		sb.append(dateOfEmpl);
		sb.append(" do chwili obecnej.\n\n\n");
		
		try {
			Files.write(Paths.get(fileName), sb.toString().getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "exportSuccess";
	}

	
	
	
	
	
	
	
	//logowanie
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String addCompanyPost(User user, Model model) {
		User loginUser = userRepository.findUserByNick(user.getNick());
		
		if ((user.getNick()).equals(loginUser.getNick()) && (user.getPassword()).equals(loginUser.getPassword())) {
			return "welcome";
		}
		return "login";
	}

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String info() {
		return "info";
	}

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
}

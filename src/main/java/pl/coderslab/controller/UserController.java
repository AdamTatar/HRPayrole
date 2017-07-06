package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userAdd";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addUserPost(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userAdd";
		}
		userRepository.save(user);
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "userList";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllCountries(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "userList";
	}
	
	
}
